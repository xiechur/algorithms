package jianzhioffer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class JZ53 {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        // 右边界
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] <= target) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        int right = i;
        if(j>=0&&nums[j] != target){
            return 0;
        }
        i = 0;

        j = nums.length - 1;
        while (i <= j) {
            int mid = (i+j)>> 1;
            if (nums[mid] < target) {
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        int left = j;
        return right-left-1;
    }

    public static void main(String[] args) {
        JZ53 jz = new JZ53();
        int[] arr = {5,7,7,8,8,10};
        int res = jz.search(arr,8);
        System.out.println(res);
    }
}
