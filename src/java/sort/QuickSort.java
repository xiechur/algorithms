package sort;

/**
 * @author xiechurong
 * @Date 2021/2/5
 */
public class QuickSort {


    public static void sort(int[] arr,int left ,int right) {
        if (left < right) {
            int partition = partition(arr,left,right);
            sort(arr,left,partition-1);
            sort(arr,partition+1,right);
        }
    }


    private static int partition(int[] arr,int left ,int right) {

        while (left < right) {
            int temp = arr[left];
            while (left < right && arr[right] >=temp) {
                right--;
            }
            swap(arr,left,right);
            while (left < right && arr[left] <= temp) {
                left++;
            }
            swap(arr,right,left);
        }
        return left;
    }


    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {16, 5, 1, 56, 18, 7, 6, 99};
        sort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
