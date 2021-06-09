package daily;

/**
 * 879. 盈利计划
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 */
public class D20210609 {

    /**
     * 分析：类似背包问题（前i件物品在j重量下的最大价值）
     * 现在是前i件物品，人数不超过j且利润达到k的 方案数
     * 状态：dp[i][j][k]  前i件物品，人数不超过j且利润达到k的 方案数
     * 方程：
     * dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - a][Math.max(0, k - b)]   j >= group[i-1]
     * dp[i - 1][j][k]                                          j < group[i-1]
     * dp[0][0][0] = 1;
     *
     * @param n         工作人员
     * @param minProfit 最低利润
     * @param group     每个工作所需工作人员
     * @param profit    利润
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int m = group.length;
        long[][][] dp = new long[m + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= m; i++) {
            int a = group[i - 1], b = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j >= a) {
                        //选中
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - a][Math.max(0, k - b)]) % mod;
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        long sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = sum + dp[m][j][minProfit];
        }
        return (int) (sum % mod);
    }


    public static void main(String[] args) {
        D20210609 d = new D20210609();
        int n = 5;
        int[] group = {2, 2};
        int[] profit = {2, 3};
        int minProfit = 3;
        d.profitableSchemes(n, minProfit, group, profit);
    }


}
