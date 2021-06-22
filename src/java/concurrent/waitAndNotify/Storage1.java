package concurrent.waitAndNotify;

import java.util.LinkedList;

/**
 * wait()、notify()、notify(All)是 Object的本地final方法，无法被重写
 * wait使得当前线程阻塞等待，前提是必须获取锁，与synchronized一起使用
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Storage1 implements AbstractStorage {

    private final int MAX_SIZE = 100;
    private LinkedList list = new LinkedList();

    public void produce(int num) {
        synchronized (list) {
            while (list.size()+num > MAX_SIZE) {
                System.out.println("仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("唤醒");
            }
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("生产商品：" + num + "储量：" + list.size());
            list.notifyAll();
        }
    }


    public void consume(int num) {
        synchronized (list) {
            while (num > list.size()) {
                System.out.println("仓库不足");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.remove();
            }
            System.out.println("消费产品：" + num + " 储量：" + list.size());
            list.notifyAll();
        }
    }

}
