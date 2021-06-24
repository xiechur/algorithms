package designPattern.observer;

/**
 * 观察/订阅者的实现类
 * @author xiechurong
 * @Date 2021/6/22
 */
public class ConcreteObserver implements Observer{


    @Override
    public void handleMsg(String msg) {
        System.out.println("收到消息 "+msg);
    }
}
