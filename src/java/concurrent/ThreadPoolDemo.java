package concurrent;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    /**
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //     public static ExecutorService newCachedThreadPool() {
        //        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //                                      60L, TimeUnit.SECONDS,
        //                                      new SynchronousQueue<Runnable>());
        //    }
        // 多少个任务，就创建多少个线程执行
        ExecutorService executorService = Executors.newCachedThreadPool();

        //     public static ExecutorService newFixedThreadPool(int nThreads) {
        //        return new ThreadPoolExecutor(nThreads, nThreads,
        //                                      0L, TimeUnit.MILLISECONDS,
        //                                      new LinkedBlockingQueue<Runnable>());
        //    }
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);

        //     public static ExecutorService newSingleThreadExecutor() {
        //        return new FinalizableDelegatedExecutorService
        //            (new ThreadPoolExecutor(1, 1,
        //                                    0L, TimeUnit.MILLISECONDS,
        //                                    new LinkedBlockingQueue<Runnable>()));
        //    }
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,0,TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));

        long start = System.currentTimeMillis();

        for (int i =0;i < 100;i++) {
//            executorService1.execute(new MyTask(i));
            threadPoolExecutor.execute(new MyTask(i));
        }


    }
    /**
     * 线程池方法
     * @param corePoolSize  核心线程数
     * @param maximumPoolSize 最大线程数，
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     */
    public void ThreadPoolExecutor(int corePoolSize,
                                   int maximumPoolSize,
                                   long keepAliveTime,
                                   TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue) {

    }


    static class MyTask implements Runnable{
        int i =0;
        public MyTask() {
        }
        public MyTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
