//package leetcode100;
//
//import java.util.Random;
//
///**
// * 215. 数组中的第K个最大元素
// * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
// *
// * 示例 1:
// *
// * 输入: [3,2,1,5,6,4] 和 k = 2
// * 输出: 5
// * 示例 2:
// *
// * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// * 输出: 4
// * 说明:
// * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// */
//public class Q215 {
//    Random random = new Random();
//    /**
//     * 快速选择排序
//     * 1.分解：将数组划分为两个子数组，使得左数组每个元素都小于右数组，计算下标
//     * 2.解决：通过递归调用快速排序，对子数组进行排序
//     * 3.合并：子数组都是原址排序的，所以不需要合并
//     * @param nums
//     * @param k
//     * @return
//     */
//    public int findKthLargest(int[] nums, int k) {
//
//    }
//
//
//    public int quickSelect(int[] arr,int left,int right,int index) {
//        int q =
//    }
//
//
//    public int randomPartition(int[] arr,int left,int right) {
//        int i = random.nextInt(right-left+1)+left;
//        swap(arr,i,right);
//        return partition();
//    }
//
//
//    private void swap(int[] arr,int a,int b) {
//        if (a != b) {
//            int temp = arr[a];
//            arr[a] = arr[b];
//            arr[b] = temp;
//        }
//    }
//
//
//
//    private int partition(int[] arr,int left,int right) {
//        int temp = arr[left];
//        while (left < right) {
//            while (left < right && arr[right] >= temp) {
//                right--;
//            }
//            swap(arr,left,right);
//            while (left < right && arr[left] <= temp) {
//                left++;
//            }
//            swap(arr,left,right);
//        }
//        return left;
//    }
//}
