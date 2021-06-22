package designPattern.singleton;

/**
 * 静态内部类：线程安全
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class StaticSingleton {

    public static class SingletonHolder{
        private static StaticSingleton INSTANCE = new StaticSingleton();
    }
    public static StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
