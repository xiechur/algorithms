package designPattern.singleton;

/**
 * 懒汉：线程不安全
 * @author xiechurong
 * @Date 2021/6/22
 */
public class LazySingleton {

    private static LazySingleton instance;

    public LazySingleton() {
    }

    /**
     * 线程不安全
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 线程安全
     * 优点：第一次调用才初始化，避免浪费
     * 缺点：方法加锁synchronized，影响效率，每次get都会进行加锁判断
     * @return
     */
    public static synchronized LazySingleton getInstance2() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
