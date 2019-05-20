package java.leetcode.page1;

public class RomanToInt {

    public int romanToInt(String s) {
        class Solution {
            public boolean isPalindrome(int x) {
                int num = 0;
                int temp = x;
                if(x== 0){
                    return true;
                }else if(x < 0){
                    return false;
                }else if (x < 10){
                    return true;
                }else{
                    while(x > 0) {
                        num = num * 10 + x%10;
                        x /= 10;
                    }
                }
                return temp == num;
            }
        }
    }

}
