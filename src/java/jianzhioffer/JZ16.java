package jianzhioffer;


/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */
public class JZ16 {

    /**
     * 时间复杂度 O(logn)
     * ​
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long a = n;
        double res = 1.0d;
        // 指数为负数 x^a = (1/x)^-a
        if (a<0) {
            x = 1/x;
            a = -a;
        }
        while (a > 0) {
            if ((a & 1) == 1) {
                // 二进制位数为1
                res *= x;
            }
            x *= x;
            a >>= 1;
        }
        return res;
    }





    public static void main(String[] args) {
        JZ16 jz = new JZ16();
        System.out.println(jz.myPow(5,5));
    }


}
