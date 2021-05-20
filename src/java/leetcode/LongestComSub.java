package leetcode;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 * @author xiechurong
 * @Date 2021/4/21
 */
public class LongestComSub {

    /**
     * 注：
     * 创建dp数组
     * dp[i][j] =
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i <=n;i++) {
            char ch1 = text1.charAt(i-1);
            for (int j = 1;j  <= m ;j++) {
                char ch2 = text2.charAt(j-1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }

    public static int[][] dp(int n,int m,int[] weight,int[] value) {
        int[][] dp = new int[n+1][m+1];
        // 初始化
        for(int j = 0;j <= m;j++) {
            dp[0][j] = 0;
        }

        // 注意边界，i从1开始 j 从0开始，dp[i-1][j]
        for (int i = 1; i <= n;i++) {
            for (int j = 0; j <=m;j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max( dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;
    }

    public static void print(int[][] dp,int n,int v,int[] weight) {
        boolean[] isAdd = new boolean[n+1];
        for (int i = n;i>= 1;i--) {
            if (dp[i][v] == dp[i-1][v]) {
                isAdd[i] = false;
            } else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }
        for (int i = 0; i <= n;i++) {
            System.out.println(isAdd[i] +" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 5;
        int m = 10;
        int[] weight ={0,2,2,6,5,4};
        int[] value ={0,6,3,5,4,6};
        int[][] dp=  dp(n,m,weight,value);
        print(dp,n,m,weight);



        String s1 = "";
//        String

    }
}
