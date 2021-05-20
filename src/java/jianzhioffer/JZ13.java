package jianzhioffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class JZ13 {

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1};
        int[] dy = {1,0};

        boolean[][] vis = new boolean[m][n];
        // 添加一个元素并返回true,如果队列已满，则返回false。
        queue.offer(new int[]{0,0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            // 将首个元素从队列中弹出（ 移除并返回队列头部的元素 ）（从队列中删除第一个元素），如果队列是空的，就返回null。
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i =0;i < 2;i++) {
                int tx = dx[i]+x;
                int ty = dy[i]+y;

                if (tx < 0|| tx>= m||ty<0 || ty>=n||vis[tx][ty] || get(tx)+get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty] = true;
                ans++;
            }

        }
        return ans;
    }


    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x%10;
            x/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ13 jz = new JZ13();
        int s = jz.movingCount(3,1,0);
        System.out.println(s);

    }

}
