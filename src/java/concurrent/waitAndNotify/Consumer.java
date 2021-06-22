package concurrent.waitAndNotify;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Consumer extends Thread {

    private int num;

    private AbstractStorage abstractStorage;

    public Consumer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num) {
        this.num =num;
    }

    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num) {
        abstractStorage.consume(num);
    }
}
