package leetcode100;

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
public class Q016 {

    // TODO
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1;
            int end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum>target) {
                    end--;
                }else if (sum < target){
                    begin++;
                }else{
                    return res;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = { -1,2,1,-4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

}