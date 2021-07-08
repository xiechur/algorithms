package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：当获取锁的时候，发现锁被其他线程获取了，不断自旋判断是否可以获取
 * 场景：锁住的代码执行时间短，
 * 优点：不会线程切换，一直处于用户态，线程一直是活跃的，线程不会进入阻塞状态，减少上下文切换，运行速度快
 *
 * 缺点：
 */
public class SpinLock {

    private AtomicReference cas = new AtomicReference();
    public void lock() {
        Thread curr = Thread.currentThread();
        // 利用CAS
        while(!cas.compareAndSet(null,curr)) {
            // 等待
        }
    }

    public void unLock() {
        Thread curr = Thread.currentThread();
        cas.compareAndSet(curr,null);
    }



}
