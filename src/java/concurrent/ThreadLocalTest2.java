package concurrent;

public class ThreadLocalTest2 {
//    private static ThreadLocal<String> sThreadLocal = new ThreadLocal<>();
//
//
//    public static void main(String args[]) {
//        sThreadLocal.set("这是在主线程中");
//        System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
//        //线程a
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                sThreadLocal.set("这是在线程a中");
//                System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
//            }
//        }, "线程a").start();
//        //线程b
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                sThreadLocal.set("这是在线程b中");
//                System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
//            }
//        }, "线程b").start();
//        //线程c
//        new Thread(() -> {
//            sThreadLocal.set("这是在线程c中");
//            System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + sThreadLocal.get());
//        }, "线程c").start();
//    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}