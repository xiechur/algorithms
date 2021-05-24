//package jianzhioffer;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 剑指 Offer 48. 最长不含重复字符的子字符串
// * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
// *
// * 示例 1:
// *
// * 输入: "abcabcbb"
// * 输出: 3
// * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// * 示例 2:
// *
// * 输入: "bbbbb"
// * 输出: 1
// * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// * 示例 3:
// *
// * 输入: "pwwkew"
// * 输出: 3
// * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
// *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// * 提示：
// *
// * s.length <= 40000
// */
//public class JZ48 {
//
//
//    /**
//     * 状态：dp[j] 代表以字符s[j] 为结尾的 最长不重复子字符串的长度
//     * 方程：
//     *
//     *      dp[j] = dp[j-1] + 1;    dp[j-1] < j-i
//     *      dp[j] = j-i             dp[j-1] >= j-i
//     *
//     * @param s
//     * @return
//     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() ==0) {
//            return 0;
//        }
//        int res = 0;
//        char[] ch = s.toCharArray();
//        int len = s.length();
//        int[] dp = new int[len];
//        for (int i =0;i < ch.length;i++) {
//
//        }
//        return res;
//    }
//
//    public int lengthOfLongestSubstring2(String s) {
//        if (s == null || s.length() ==0) {
//            return 0;
//        }
//        int res = 0;
//        Map<Character, Integer> dic = new HashMap<>();
//        int temp =0;
//        for (int j = 0;j < s.length();j++) {
//            int i = dic.getOrDefault(s.charAt(j), -1);
//            dic.put(s.charAt(j), j);
//            temp = temp < j-i?temp+1:j-i;
//            res = Math.max(temp,res);
//        }
//        return res;
//    }
//
//    public int lengthOfLongestSubstring3(String s) {
//        if (s == null || s.length() ==0) {
//            return 0;
//        }
//        Map<Character, Integer> dic = new HashMap<>();
//        int res = 0;
//        int i = -1;
//        for (int j = 0;j < s.length();j++) {
//            if (dic.containsKey(s.charAt(j))) {
//                i = Math.max(i,dic.get(s.charAt(i)));
//            }
//            dic.put(s.charAt(j), i);
//            res = Math.max(res,j-i);
//        }
//        return res;
//    }
//
//
//
//
//    public static void main(String[] args) {
//
//        JZ48 jz = new JZ48();
//        int res = jz.lengthOfLongestSubstring("");
//        System.out.println(res);
//
//    }
//
//}
//
