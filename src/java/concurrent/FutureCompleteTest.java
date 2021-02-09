package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author xiechurong
 * @Date 2020/1/19
 */
public class FutureCompleteTest {



    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        CompletableFuture<String> completableFuture1 = completedFutureGetA();
        CompletableFuture<String> completableFuture2 = completedFutureGetB();
        CompletableFuture<String> completableFuture3 = completedFutureGetC();
        CompletableFuture.allOf(completableFuture1,completableFuture2,completableFuture3).thenRun(()-> System.out.println("finish")).join();
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);


        String ss= "{\"type\":\"16\",\"expireTotalMinutes\":\"0\",\"class\":\"class com.huya.hcg.tars.idl.generated.hcg.Goods\",\"descn\":\"\",\"extData\":\"{\\\"autoOpen\\\": 1, \\\"items\\\": [{\\\"itemId\\\": 1, \\\"amount\\\": 300, \\\"expireSeconds\\\": -1, \\\"goodsId\\\": 393, \\\"attachInfo\\\": \\\"{\\\\\\\"payerUid\\\\\\\":1599517144344,\\\\\\\"prodId\\\\\\\":\\\\\\\"platfrom_rank_1045\\\\\\\"}\\\"} ] }\",\"ename\":\"全平台贡献日榜TOP11~20奖励\",\"measureType\":\"1\",\"md5\":\"acbdcb4b08c5d02de30dcdae26ebeac8\",\"createBy\":\"\",\"id\":\"588\",\"imgUrl\":\"image/common2/202005/20/1589955672145/9eb8f7e15d91c444.png\",\"mergeNum\":\"0\",\"amount\":\"1\",\"coverImage\":\"\",\"merged\":\"2\",\"expireInterMinutes\":\"0\",\"lastUpdateTime\":\"0\",\"updateBy\":\"\",\"cname\":\"全平台贡献日榜TOP11~20奖励\"}";;
        System.out.println(ss);
    }


    public static CompletableFuture<String> completedFutureGetA() {
        return CompletableFuture.supplyAsync(()->getA());
    }
    public static CompletableFuture<String> completedFutureGetB() {
        return CompletableFuture.supplyAsync(()->getB());
    }
    public static CompletableFuture<String> completedFutureGetC() {
        return CompletableFuture.supplyAsync(()->getC());
    }

    private static String getA() {
        System.out.println("get A :" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "A";
    }

    private static String getB() {
        System.out.println("get B :" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "B";
    }

    private static String getC() {
        System.out.println("get C :" + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "C";
    }
}
