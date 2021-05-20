package sort;

/**
 * @author xiechurong
 * @Date 2021/5/11
 */
public class MergeSort {


    public static void sort(int[] arr,int left,int right) {
        int mid = (left+right)/2;
        if (left<right) {
            // 左边
            sort(arr,left,mid);
            // 右边
            sort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right) {
        // 新建一个临时数组
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        // 把较小的数现已到新数组中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 把新数组的数覆盖原数组

        for (int k2 = 0;k2<temp.length;k2++) {
            arr[left+k2] = temp[k2];
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,1};
        sort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }



}
