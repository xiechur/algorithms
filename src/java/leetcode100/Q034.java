package leetcode100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */
public class Q034 {


    public int[] searchRange(int[] nums, int target) {
        if (nums == null||nums.length ==0) {
            return new int[] {-1,-1};
        }
        int x = -1,y = -1;
        int left = 0,right = nums.length-1;
        // 找到左边界
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] <= target) {
                left= mid+1;
            }else {
                right = mid-1;
            }
        }
        y = left-1;
        left = 0;
        right = nums.length-1;
        // 找到右边界
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] >= target) {
                right--;

            }else {
                left++;
            }
        }
        x=  right+1;
        return new int[] {x,y};
    }



    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1,mid =-1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Q034 q = new Q034();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = q.searchRange(nums,target);
        for (int i :res) {
            System.out.println(i);
        }
    }

}
