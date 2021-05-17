package sort;

/**
 * @author xiechurong
 * @Date 2021/2/5
 */
public class ShellSort {


    public static void sort(int[] arr) {
        // 步长
        for (int step = arr.length/2;step > 0;step /=2) {
            for (int i = step;i < arr.length;i++) {
                int index = i;
                int temp= arr[i];
                if (arr[index] < arr[index-step]) {
                    while (index-step >= 0 && temp < arr[index-step]) {
                        // 向右step移动
                        arr[index] = arr[index-step];
                        index-=step;
                    }
                    arr[index] = temp;
                }
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
