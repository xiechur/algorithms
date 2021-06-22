package designPattern.factorMethod;

/**
 * 工厂方法：
 * 四个部分：
 *  抽象产品，工厂创建的超类
 *  具体产品，具体实现
 *  抽象工厂，核心，必须实现该接口
 *  具体工厂，实现了工厂接口
 *
 *  优点：创建对象的接口，让子类去决定具体实例化的对象，把简单的内部逻辑判断移到了客户端，客服了简单工厂违背开闭原则的缺点，保持了封装对象创建过程的优点
 *
 *
 *  场景：
 *
 *
 *  新增功能不需要修改现有功能
 *
 *  JDK用到：
 *   java.lang.Object#toString() (在其子类中可以覆盖该方法)
 *
 * • java.lang.Class#newInstance()
 *
 * • java.lang.Integer#valueOf(String) (Boolean, Byte,Character,Short, Long, Float 和 Double与之类似)
 *
 * • java.lang.Class#forName()
 *
 * • java.lang.reflect.Array#newInstance()
 *
 * • java.lang.reflect.Constructor#newInstance()
 *  Spring用到：
 *  BeanFactory ：延迟注入(使用到某个 bean 的时候才会注入),相比于BeanFactory来说会占用更少的内存，程序启动速度更快。
 *
 *
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Client {


    public static void main(String[] args) {
        CarFactory factory = null;
        factory = new BikeFactory();
        Car bike = factory.getCar();
        bike.gotoWork();


        factory = new BusFactory();
        Car bus = factory.getCar();
        bus.gotoWork();
    }
}
