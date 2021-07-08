package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 并发处理1000个订单，然后打印失败的订单
 */
public class FailOrderIds {

    public static List<Long> orderIds = new ArrayList<>();

    static {
        for (long i = 0; i < 1000; i++) {
            orderIds.add(10000000 + i);
        }
    }

    public static void consumeOrderId(long orderId) throws InterruptedException {
        Thread.sleep(100);
        if (orderId % 100 == 0) {
            throw new RuntimeException("error");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        List<Long> res = new ArrayList<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        int size = orderIds.size();
        List<Future<List<Long>>> futures = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            // 分页:[0,100),[100,200) 左闭右不闭 每页的数目:size/nThread
            List<Long> orderBatch = orderIds.subList(size / nThreads * i, size / nThreads * (i + 1));
            Callable<List<Long>> task = new Callable<List<Long>>() {
                List<Long> res = new ArrayList<>();

                @Override
                public List<Long> call() throws Exception {
                    for (long orderId : orderBatch) {
                        try {
                            consumeOrderId(orderId);
                        } catch (Exception e) {
                            // 失败的时候加到list
                            res.add(orderId);
                        }
                    }
                    return res;
                }
            };
            Future<List<Long>> future = service.submit(task);
            futures.add(future);
        }
        for (Future<List<Long>> future:futures) {
            List<Long> failOrderIds = future.get();
            res.addAll(failOrderIds);
        }
        service.shutdown();
        for (Long orderId : res) {
            System.out.println(orderId);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

    }


    public static void main2(String[] args) throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        List<Long> res = new ArrayList<>();
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        int size = orderIds.size();
        List<Callable<List<Long>>> tasks = new ArrayList<>();
        for (int i = 0; i < nThreads; i++) {
            // 分页
            List<Long> orders = orderIds.subList(size / nThreads * i, size / nThreads * (i + 1));
            Callable<List<Long>> task = new Callable<List<Long>>() {
                List<Long> res = new ArrayList<>();

                @Override
                public List<Long> call() throws Exception {
                    for (long orderId : orders) {
                        try {
                            consumeOrderId(orderId);
                        } catch (Exception e) {
                            res.add(orderId);
                        }
                    }
                    return res;
                }
            };
            tasks.add(task);
        }
        List<Future<List<Long>>> futures = service.invokeAll(tasks);
        for (Future<List<Long>> future : futures) {
            res.addAll(future.get());
        }

        service.shutdown();
        for (long orderId : res) {
            System.out.println(orderId);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
}
