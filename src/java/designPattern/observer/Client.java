package designPattern.observer;

/**
 * 观察者模式
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Client {


    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        // 向上转型：当我们需要多个同父的对象调用某个方法时,通过向上转换后,则可以确定参数的统一.方便程序设计
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();

        subject.sub(observer1);
        subject.sub(observer2);

        subject.notifyObservers("1");
        subject.unSub(observer2);


        subject.notifyObservers("2");


    }
}
