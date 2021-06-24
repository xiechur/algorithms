package basic;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 微信随机红包
 * 需求简介：群里多人抢红包，红包内金额可以按照发出人指定成随机多份
 * <p>
 * <p>
 * 每次随机获取 [0.01,remainMoney*2/remainSize] 确保均匀发布
 * <p>
 * 实时计算，不需要预先分配，基于系统内存，不用额外的存储空间
 * <p>
 * <p>
 * 请求队列如果超过红包个数，直接返回。
 * <p>
 * <p>
 * 参考《微信红包的架构设计简介》：https://www.zybuluo.com/yulin718/note/93148
 *
 * @author xiechurong
 * @Date 2021/6/24
 */
public class WXRedBag {

    public static BigDecimal getRandonMoney(RedPackage redPackage) {
        if (redPackage.remainSize == 1) {
            redPackage.remainSize--;
            return redPackage.remainMoney.setScale(2, BigDecimal.ROUND_DOWN);
        }
        // 最小值
        BigDecimal min = BigDecimal.valueOf(0.01);
        // 最大值
        BigDecimal max = redPackage.remainMoney
                .multiply(new BigDecimal(2))
                .divide(new BigDecimal(redPackage.remainSize), BigDecimal.ROUND_HALF_UP)
                .setScale(2, BigDecimal.ROUND_DOWN);
        // 找到一个在min与max之间的随机值
        BigDecimal random = BigDecimal.valueOf(Math.random());
        BigDecimal money = random.multiply(max).setScale(2, BigDecimal.ROUND_DOWN);
        // 兜底，最低值用0.01
        money = money.compareTo(min) < 0 ? min : money;
        redPackage.remainSize--;
        redPackage.remainMoney = redPackage.remainMoney.subtract(money).setScale(2, BigDecimal.ROUND_DOWN);
        return money;
    }


    public static void main(String[] args) {
        int total = 10;
        double totalMoney = 100d;
        int times =100;
        double[][] arr = new double[times][total];
        for (int i = 0; i < times; i++) {
            BigDecimal remainMoney = BigDecimal.valueOf(totalMoney);
            RedPackage redPackage = new RedPackage();
            redPackage.remainMoney = remainMoney;
            redPackage.remainSize = total;
            while (redPackage.remainSize != 0) {
                int index = total-redPackage.remainSize;
                BigDecimal temp = getRandonMoney(redPackage);
                System.out.print(temp + " ");
                arr[i][index] = temp.doubleValue();
            }
            System.out.println();
        }

        for (int i = 0;i <total;i++) {
            int finalI = i;
            double avg = Arrays.asList(arr).stream().mapToDouble(o -> o[finalI]).average().getAsDouble();
            System.out.println("第"+i+"次抢红包平均金额："+avg);
        }
    }

    static class RedPackage {
        int remainSize;
        BigDecimal remainMoney;

    }


}
