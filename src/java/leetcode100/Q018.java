package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

 */
public class Q018 {


    // 在原有的三个数之和的外层遍历
    public static List<List<Integer>> fourSum(int[] nums, int target)  {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i2 = 0; i2 < len - 3; i2++) {
            if (i2 > 0 && nums[i2] == nums[i2 - 1]) continue;
            for (int i = i2 + 1; i < len - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int begin = i + 1;
                int end = len - 1;
                while (begin < end) {
                    int sum = nums[i2] + nums[i] + nums[begin] + nums[end];
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        begin++;
                    } else {
                        res.add(Arrays.asList(nums[i2] ,nums[i], nums[begin], nums[end]));
                        while (begin < end && nums[begin] == nums[begin + 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                        begin++;
                    }
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int [] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums,target).toString());
    }

}