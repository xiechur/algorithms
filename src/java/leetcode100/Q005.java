package leetcode100;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Q005 {

    // 1.暴力法，遍历所有子串，判断是否回文串
    // 时间复杂度：O(n^3)
    public static String longestPalindrome1(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > result.length()) {
                    result = test;
                }
            }
        }
        return result;
    }

    // 2.倒序，然后两个字符串的最长公共子串
    // 时间复杂度：  O(n^2)
    public static String longestPalindrome2(String s) {
        char[] c1 = s.toCharArray();
        char[] c2 = new char[c1.length];
        for (int i = 0; i < c1.length; i++) {
            c2[i] = c1[c1.length - i - 1];
        }
        String s2 = new String(c2);
        return getLCS2(s,s2);
    }

    // 最长公共子串：动态规划
    // A:abcdef B={bcdegg}
    // 1.when A[i]!=B[j] ,then dp[i][j]
    // 2.when A[i]==B[j] then
    //                      when i == 0||j==0 then dp[i][j]=1  else dp[i][j]=dp[i-1][j-1]+1
    public int getLCS(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int fromIndex = 0;
        int toIndex = 0;
        int[][] dp = new int[sLength][tLength];
        for (int i = 1; i < sLength; i++) {
            for (int j = 1; j < tLength; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                        fromIndex = i;
                        toIndex = j;
                    }

                }
            }
        }
        return result;
    }
    // 最长公共子串：动态规划
    // A:abcdef B={bcdegg}
    // 1.when A[i]!=B[j] ,then dp[i][j]
    // 2.when A[i]==B[j] then
    //                      when i == 0||j==0 then dp[i][j]=1  else dp[i][j]=dp[i-1][j-1]+1
    public static  String getLCS2(String s, String t) {
        System.out.println(s);
        System.out.println(t);
        if (s == null || t == null) {
            return "";
        }
        int result = 0;
        int sLength = s.length();
        int tLength = t.length();
        int toIndex = 0;
        int fromIndex = 0;
        int[][] dp = new int[sLength][tLength];
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < tLength; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (i ==0 || j ==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > result) {
                        int before = sLength - 1 - j;
                        if (before + dp[i][j] -1 == j) {
                            result = dp[i][j];
                            toIndex = i;
                        }
                    }
                }
            }
        }
        for (int i = 0;i<sLength;i++) {
            System.out.print(s.charAt(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < tLength; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        int index = Math.max(fromIndex,toIndex);
        if (index > 0 && index > result) {
            return s.substring(index - result + 1, index + 1);
        }
        return "";
    }


    public static boolean isPalindrome(String test) {
        for (int i = 0; i < test.length() / 2; i++) {
            if (test.charAt(i) != test.charAt(test.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String string = "aabbccbbaeraabbccbbaabbnnc";
        String string2 = "aabbccbbaeraabb";
//        System.out.println(longestPalindrome1(string));
        System.out.println(longestPalindrome2(string));
        System.out.println(longestPalindrome2(string2));
//        System.out.println(longestPalindrome1(string));
//        System.out.println(longestPalindrome1(string));
    }
}
