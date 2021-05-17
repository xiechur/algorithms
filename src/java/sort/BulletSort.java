package sort;

/**
 * @author xiechurong
 * @Date 2021/2/5
 */
public class BulletSort {


    public static void sort(int[] arr) {
        // 位置控制
        for (int i = 1;i < arr.length;i++) {
            boolean flag = true;
            for (int j = 0;j < arr.length-i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                return;
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
