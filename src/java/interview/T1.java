package interview;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author xiechurong
 * @Date 2021/5/31
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                // 只出现一次
                nums[i][j] = scanner.nextInt();
            }
        }
        int[] res = fun(nums);
        for (int i :res) {
            System.out.println(i);
        }
    }


    private static int[] fun(int[][] nums) {
        int[] res= new int[nums.length];
        for (int i = 0;i < nums.length;i++) {
            HashSet<Integer> set = new HashSet<>();
            res[i] = -1;
            for (int j =0;i < nums[i].length;i++) {
                res[i] = Math.min(res[i], nums[i][j]);
            }
        }
        return res;
    }


}
