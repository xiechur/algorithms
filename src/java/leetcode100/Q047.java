package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Q047 {


    // 回溯
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,nums.length,0,path,res,used);
        return res;
    }

    private static void dfs(int[] nums,int len,int depth,List<Integer> path,List<List<Integer>> res,boolean[] used) {
        if (depth ==  len) {
            res.add(path);
            return;
        }
        for (int i = 0; i < len;i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,res,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
    }

}