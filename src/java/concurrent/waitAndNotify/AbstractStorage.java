package concurrent.waitAndNotify;

/**
 * @author xiechurong
 * @Date 2021/6/22
 */
public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
