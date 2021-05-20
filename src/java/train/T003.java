package train;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiechurong
 * @Date 2021/5/11
 */
public class T003 {
    // 某阶段 某状态的 最优值

    void backtrack() {

    }

    public static void main(String args[]){
        FutureTask<String> futureTask =new FutureTask<String>(new MyCallable());
        Thread thread=new Thread(futureTask,"Mycallable");
        thread.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间"+new Date().getTime());
        }
        String result= null;
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
