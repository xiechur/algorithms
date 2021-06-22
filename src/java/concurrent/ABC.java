package concurrent;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiechurong
 * @Date 2021/6/21
 */
public class ABC {


    /**
     * ABC三个线程同时执行
     */
    public void f1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);


        for (int i = 0;i < 3;i++) {
            final int temp = i;
            int finalI = i;
            String s = null;
            if (i == 0) {
                s = "A";
            } else if (i == 1){
                s = "B";
            } else if (i == 2) {
                s = "C";
            }
            String finalS = s;
            executorService.submit(()->print(finalS,countDownLatch));
        }


//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        executorService.submit(()->{
//           try {
//               countDownLatch.await();
//            }catch (Exception e) {
//                e.printStackTrace();
//           }
//            System.out.println("线程A执行，执行时间："+System.currentTimeMillis());
//        });
//        executorService.submit(()->{
//           try {
//               countDownLatch.await();
//            }catch (Exception e) {
//                e.printStackTrace();
//           }
//            System.out.println("线程B执行，执行时间："+System.currentTimeMillis());
//        });
//        executorService.submit(()->{
//           try {
//               countDownLatch.await();
//            }catch (Exception e) {
//                e.printStackTrace();
//           }
//            System.out.println("线程C执行，执行时间："+System.currentTimeMillis());
//        });

        try {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  void print (String s,CountDownLatch countDownLatch) {
        for (int i = 0 ;i < 10;i++) {
            System.out.println(s+" - " + i +" - "+System.currentTimeMillis());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        countDownLatch.countDown();
    }

    private  volatile int count = 0;

    /**
     * ABC三个线程依次执行
     */
    public void f2() {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
           while (true) {
               if (count == 0) {
                   for (int i = 0;i < 10;i++) {
                       System.out.println("A - " + i +" - "+System.currentTimeMillis());
                   }
                   count = 1;
                   break;
               }
           }
        });
        executorService.submit(()->{
           while (true) {
               if (count == 1) {
                   for (int i = 0;i < 10;i++) {
                       System.out.println("B - " + i +" - "+System.currentTimeMillis());
                   }

                   count = 2;
                   break;
               }
           }
        });
        executorService.submit(()->{
           while (true) {
               if (count == 2) {
                   for (int i = 0;i < 10;i++) {
                       System.out.println("C - " + i +" - "+System.currentTimeMillis());
                   }
                   count = 3;
                   break;
               }
           }
        });



    }


    private static final ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    /**
     * ABC三个线程有序交错进行
     */
    public void f3() {
        new Thread(() -> {
            try {
                lock.lock();

                for (int i = 0; i < 10; i++) {
                    System.out.println("A - " + i +" - "+System.currentTimeMillis());
                    c2.signal();
                    c1.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();

                for (int i = 0; i < 10; i++) {
                    System.out.println("B - " + i +" - "+System.currentTimeMillis());
                    c3.signal();
                    c2.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();

                for (int i = 0; i < 10; i++) {
                    System.out.println("C - " + i +" - "+System.currentTimeMillis());
                    c1.signal();
                    c3.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }


    public static void main(String[] args) {
        ABC abc = new ABC();
        abc.f3();
    }
}
