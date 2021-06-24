package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题：实现主题类，处理观察者订阅，取消订阅，通知
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class ConcreteSubject implements Subject{

    // 维护订阅关系
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void sub(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSub(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer:observers) {
            observer.handleMsg(msg);
        }
    }
}
