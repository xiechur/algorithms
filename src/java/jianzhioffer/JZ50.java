package jianzhioffer;


import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class JZ50 {

    public char firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        int[] counter = new int[26];
        for (int i =0;i < s.length();i++){
            char ch = s.charAt(i);
            frequency.put(ch,frequency.getOrDefault(ch,0)+1);
        }
        for (int i =0;i < s.length();i++) {
            if (frequency.get(s.charAt(i))  == 1) {
                return s.charAt(i);
            }

        }
        return ' ';
    }


    public static void main(String[] args) {

        JZ50 jz = new JZ50();
        char res = jz.firstUniqChar("abaccdeff");
        System.out.println(res);

    }

}

