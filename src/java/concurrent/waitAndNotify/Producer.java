package concurrent.waitAndNotify;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Producer extends Thread {

    private int num;

    private AbstractStorage abstractStorage;

    public Producer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num) {
        this.num =num;
    }

    @Override
    public void run() {
        producer(num);
    }

    public void producer(int num) {
        abstractStorage.produce(num);
    }
}
