package leetcode100;

import java.util.Arrays;
import java.util.List;

/**
 * 4. 寻找两个有序数组的中位数 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1: nums1 = [1, 3] nums2 = [2] 则中位数是 2.0
 * 示例 2: nums1 = [1, 2] nums2 = [3, 4] 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class Q004 {

    // 1.合并为一个数组，然后排序取中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.asList(1,2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < l1+l2;i++) {
            if (i < l1) {
                nums3[i] = nums1[i];
            } else {
                nums3[i] = nums2[i-l1];
            }
        }
        Arrays.sort(nums3);
        for (int i : nums3) {
            System.out.println(i);
        }
        return (double) (nums3[(l1 + l2 - 1) / 2] + nums3[(l1 + l2) / 2]) / 2;
    }

    // 1.合并为一个数组，然后排序取中位数
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.asList(1,2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < l1+l2;i++) {
            if (i < l1) {
                nums3[i] = nums1[i];
            } else {
                nums3[i] = nums2[i-l1];
            }
        }
        Arrays.sort(nums3);
        for (int i : nums3) {
            System.out.println(i);
        }
        return (double) (nums3[(l1 + l2 - 1) / 2] + nums3[(l1 + l2) / 2]) / 2;
    }





    public static void main(String[] args) {
        int[] nums1 = { 9, 10, 11, 12, 13, 14 };
        int[] nums2 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
//		int[] nums1 = { 1 };
//		int[] nums2 = { 2 };

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
