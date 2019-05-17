package leetcode.page1;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * link : https://leetcode.com/problems/two-sum/
 * @author xiechurong
 * @Date 2019/3/16
 */
public class TwoSum {

    /**
     * Brute Force
     * O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length;i++) {
            for (int j = i +1;j < nums.length;j++) {
                int temp = target-nums[i];
                if (temp == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    public static int[] twoSum2(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0 ;i < nums.length;i++) {
                map.put(nums[i], i);
            }

            for (int j = 0 ; j < nums.length;j++) {
                int temp = target - nums[j];
                if (map.containsKey(temp) && map.get(temp) != j) {
                    return new int[]{j,map.get(temp)};
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] a = {2,7,9,10};
        int target = 9;
        int[] b = twoSum2(a,target);
        System.out.println(b);
    }



}
