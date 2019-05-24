package java.leetcode;

public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0 ; i< length;i++) {
            int num = num(s.charAt(i));
            if (i < length-1) {
                int num2 = num(s.charAt(i+1));
                if (num < num2) {
                    result += num2 - num;
                    i++;
                }else {
                    result += num;
                }
            } else {
                result += num;
            }
        }
        return result;

    }

    private int num(char ch) {
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }



}
