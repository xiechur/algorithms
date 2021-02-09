package leetcode100;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Q007 {

    // 1.判断是否超过数值范围
    public static int reverse1(int x) {
        int result = 0;

        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && x % 10 > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && x % 10 < -8)) {
                return 0;
            }
            result = result * 10 + x % 10;  // 看看是否会溢出
            x /= 10;
        }
        return result;
    }




    public static void main(String[] args) {
        System.out.println(reverse1(-123));
    }
}
