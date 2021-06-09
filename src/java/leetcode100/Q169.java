package leetcode100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class Q169 {

    /**
     * 排序，取中间位置
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    /**
     * HashMap
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer,Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     * 候选人cand_num 初始化为nums[0]，票数count为1
     * 当遇到相同的数，count++，否则count--
     * 票数为0时，更换候选人，count = 1
     * 遍历完数组后，cand_num 就是最终答案
     *
     */
    public int majorityElement3(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1;i < nums.length;i++) {
            if (cand_num == nums[i]) {
                count++;
            } else if (--count ==0){
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }



}
