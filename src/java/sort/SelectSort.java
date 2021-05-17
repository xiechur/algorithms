package sort;

/**
 * @author xiechurong
 * @Date 2021/2/5
 */
public class SelectSort {


    public static void sort(int[] arr) {
        // 每次选择一个最小的到
        for (int i = 0;i < arr.length;i++) {
            int min = i;
            for (int j = i+1 ;j< arr.length;j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }




    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {16, 5, 1, 56, 18, 7, 6, 99};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
