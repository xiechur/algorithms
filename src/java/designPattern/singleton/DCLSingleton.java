package designPattern.singleton;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class DCLSingleton {


    private volatile static DCLSingleton simpleSingleton = null;

    // 分配内存，初始化，指针指向


    /**
     *
     * @return
     */
    public static DCLSingleton getSingletonInstanse() {
        if (simpleSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (simpleSingleton == null) {
                    simpleSingleton = new DCLSingleton();
                }
            }

        }
        return simpleSingleton;
    }


}
