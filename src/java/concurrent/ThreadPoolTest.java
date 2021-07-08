package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        for (int i =0; i < 1000;i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            // 阻塞
            thread.join();
        }
        System.out.println("times:"+(System.currentTimeMillis()-start));
        System.out.println("size:"+list.size());

        // 使用线程池
        start = System.currentTimeMillis();
        final List<Integer> list2 = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i =0; i < 10000;i++) {
            executorService.execute(()->{
                list2.add(random.nextInt());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("times:"+(System.currentTimeMillis()-start));
        System.out.println("size:"+list2.size());


    }
}
