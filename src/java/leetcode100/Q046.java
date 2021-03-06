package leetcode100;

import sun.security.krb5.internal.rcache.DflCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */
public class Q046 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);

                    }
                }
            }
        }
        return res;
    }


    // 回溯
    public static List<List<Integer>> permute2(int[] nums) {
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