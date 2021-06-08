package leetcode100;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class Q096 {


    /**
     * 动态规划：
     * 状态：dp[i] 代表i个节点组成的二叉树种数量
     * 方程：dp[i] = E (dp[j] * dp[i-j-1])
     *      dp[1] = 1,
     *      dp[0] = 1,
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int mat = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i <= n;i++) {
            for (int j = 0;j < i;j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
