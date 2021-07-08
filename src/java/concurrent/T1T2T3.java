package concurrent;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class T1T2T3 {

    public static void main(String[] args) throws InterruptedException {
        T1T2T3 t = new T1T2T3();
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }


    static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0;i<10;i++) {
                System.out.println("T1:"+i);
            }
        }
    }
    static class T2 extends Thread{
        @Override
        public void run() {
            for (int i = 0;i<10;i++) {
                System.out.println("T2:"+i);
            }
        }
    }
    static class T3 extends Thread{
        @Override
        public void run() {
            for (int i = 0;i<10;i++) {
                System.out.println("T3:"+i);
            }
        }
    }

}
