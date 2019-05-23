package java.leetcode;

public class MyAtoi {

    public int myAtoi(String str) {

        char[] s = str.toCharArray() ;
        int i = 0 , sign = 1;
        long num = 0 ;
        if(str.length() == 0) return 0 ;
        // white spaces
        while(i < str.length() && s[i] == ' ') i++ ;
        //sign
        if(i < str.length() && (s[i] == '-' || s[i] == '+')){
            sign = s[i++] == '-' ? -1 : 1 ;
        }
        while(i < str.length() && s[i] >= '0' && s[i] <= '9'){
            num = num*10 + (s[i] - '0') ;
            if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
            }
            i++ ;
        }
        num *= sign ;
        return (int)num ;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        myAtoi.myAtoi("-42");
    }
}


