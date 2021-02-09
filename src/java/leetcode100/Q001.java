package leetcode100;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * */
public class Q001 {

    // 暴力法
    public static int[] twoSum(int[] nums,int target) {
        for (int i = 0; i < nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("fail");
    }


    // hash方式
    // key: 值  value:下标   轮循nums:判断target-nums[i]是否在hashmap中（注意：不能是相同的元素，要过滤map.get[target-nums[i]] != i） ;
    public static int[] twoSum2(int[] nums,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length;i++) {
            int a = target - nums[i];
            if (map.containsKey(a) && map.get(a) != i) {
                return new int[]{i,map.get(a)};
            }
        }
        throw new IllegalArgumentException("fail");
    }


    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int target = 9;
        int[] arr = twoSum2(nums,target);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
