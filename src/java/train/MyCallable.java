package train;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author xiechurong
 * @Date 2021/5/14
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间"+new Date().getTime());
        }
        return "MyCallable接口执行完成！！";
    }
}
