package leetcode.page1;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * link : https://leetcode.com/problems/reverse-integer/
 * 123   3
 * 12    32
 * 1     321
 *
 * @author xiechurong
 * @Date 2019/5/18
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int a = x % 10;
            result = result * 10 + a;
            x /= 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
    }
}
