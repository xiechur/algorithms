package leetcode;

/**
 * @author xiechurong
 * @Date 2019/5/24
 */
public class Palindrome {

    public boolean isPalindrome(int x) {
        int num = 0;
        int temp = x;
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            while (x > 0) {
                num = num * 10 + x % 10;
                x /= 10;
            }
        }
        return temp == num;
    }
}
