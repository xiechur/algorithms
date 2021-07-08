package concurrent.atomic;

import textbook.A;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        // 先通过反射后去到value成员变量对应的Field对象，再通过objectFieldOffset函数转化为valueOffset，此处的offset代表了value变量本身，后面执行CAS，不是直接操作value,而是valueOffset
        int a= count.getAndAdd(1);
        System.out.println(a);//0
        int b = count.addAndGet(1);
        System.out.println(b);//2


        // 自旋与阻塞：拿不到锁的时候会有两种策略，可以结合使用，如synchronized 自旋几次之后还拿不到锁，就阻塞


    }


}
