package leetcode100;

import java.util.*;

/*
139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */
public class Q139 {
    //dp[i] 表示字符串 s 前 i个字符组成的字符串 s[0..i-1]s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
    // dp[i] == dp[j] && check(s[j,i-1])
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int j = 1;j <= s.length();j++){
            for(int i = 0;i < j;i++) {
                if(dp[i] && set.contains(s.substring(i,j))) {
                    dp[j] = true;
                    break;
                }


            }
        }
        return dp[s.length()];
    }





    public static void main(String[] args) {

        String s = "123456";
        System.out.println(s.substring(1,2));
        int[] nums = {-1, 0, 1, 2, -1, -4};
    }

}