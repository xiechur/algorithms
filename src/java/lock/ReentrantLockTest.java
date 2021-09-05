package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：应用场景
 * 场景1：如果发现该操作已经在执行中则不再执行（有状态执行）
 *  if (lock.tryLock()) {  //如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
 *                     try {
 *                        //操作
 *                     } finally {
 *                         lock.unlock();
 *                     }
 *
 *                 }
 * 场景2：如果发现该操作已经在执行，等待一个一个执行（同步执行，类似synchronized）
 * try {
 *                         lock.lock(); //如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
 *
 *                        //操作
 *
 *                     } finally {
 *                         lock.unlock();
 *                     }
 * 场景3：如果发现该操作已经在执行，则尝试等待一段时间，等待超时则不执行（尝试等待执行）
 * try {
 *                     if (lock.tryLock(5, TimeUnit.SECONDS)) {  //如果已经被lock，尝试等待5s，看是否可以获得锁，如果5s后仍然无法获得锁则返回false继续执行
 *                         try {
 *                             //操作
 *                         } finally {
 *                             lock.unlock();
 *                         }
 *                     }
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace(); //当前线程被中断时(interrupt)，会抛InterruptedException
 *                 }
 * 场景4：如果发现该操作已经在执行，等待执行。这时可中断正在进行的操作立刻释放锁继续下一操作。
 * try {
 *                     lock.lockInterruptibly();
 *                     //操作
 *
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace();
 *                 } finally {
 *                     lock.unlock();
 *                 }
 * private ReentrantLock lock = new ReentrantLock(); //参数默认false，不公平锁
 * private ReentrantLock lock = new ReentrantLock(true); //公平锁
 * 不公平锁与公平锁的区别：
 * 公平情况下，操作会排一个队按顺序执行，来保证执行顺序。（会消耗更多的时间来排队）
 * 不公平情况下，是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队。（如果不关心顺序，这个速度会更快）
 *
 */
public class ReentrantLockTest {

    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.nanoTime());
        for(int i=0;i<5;i++){
            new Thread(new ThreadDemo(i)).start();
        }

    }

    static class ThreadDemo implements Runnable {
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override

        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<2;i++){
                lock.lock();
                System.out.println("获得锁的线程："+id);
                lock.unlock();
            }
        }
    }
}