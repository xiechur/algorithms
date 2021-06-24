package designPattern.observer;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public interface Subject {

    // 添加订阅关系
    void sub(Observer observer);
    // 删除订阅关系
    void unSub(Observer observer);
    // 通知订阅者
    void notifyObservers(String msg);

}
