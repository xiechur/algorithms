package designPattern.singleton;

/**
 * 饿汉单例：线程安全
 * 优点：简单，易产生垃圾
 * 缺点：类加载就初始化，浪费内存
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class HangrySingleton {

    private static HangrySingleton instance = new HangrySingleton();
    private HangrySingleton() {}
    public static HangrySingleton getInstance() {
        return instance;
    }

}
