package leetcode100;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Q221 {

    /**
     * 时间复杂度：O(mn min(m,n)^2)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix  == null | matrix.length ==0|| matrix[0].length ==0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0;i <n;i++) {
            for (int j = 0;j <m;j++) {
                if (matrix[i][j] ==  '1') {
                    res = Math.max(res,1);
                    int x = Math.min(n-i,m-j);
                    for (int k = 1;k < x;k++)  {
                        // 判断新增的一行一列是否为1
                        boolean flag = true;
                        if (matrix[k+i][j+k] == '0') {
                            break;
                        }
                        for (int v = 0;v < k;v++) {
                            if (matrix[i+k][j+m] == '0'||matrix[i+m][j+k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            res = Math.max(res,k+1);
                        } else {
                            break;
                        }
                    }

                }
            }
        }
        res = res*res;
        return res;
    }


    /**
     * 动态规划
     * 状态：dp[i][j] 以matrix[i][j] 为右下角，且包含1的正方形的边长最大值
     * 方程：
     *      dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
     *      dp[0][j] = 1;
     *      dp[i][0] = 1;
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int res = 0;
        if (matrix == null | matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n;i++) {
            for (int j = 0;j <m;j++) {
                if (matrix[i][j] ==  '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        res = maxSide*maxSide;
        return res;
    }

}
