package jianzhioffer;


/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class JZ49 {


    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0,b=0,c=0;
        dp[0] = 1;
        for (int i = 1;i < n;i++) {
            int n2 = dp[a] *2,n3 = dp[b]*3,n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }

        }

        return dp[n-1];
    }



    public static void main(String[] args) {

        JZ49 jz = new JZ49();
        int res = jz.nthUglyNumber(100);
        System.out.println(res);

    }

}

