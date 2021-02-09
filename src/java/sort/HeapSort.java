package sort;

/**
 * @author xiechurong
 * @Date 2021/2/5
 */
public class HeapSort {


    public static void heapSort(int[] list) {
        // 从最后一个非叶子节点开始调整，左右节点大的交换到父节点中
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            heapAdjust(list, list.length, i);
        }
        // 排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapAdjust(list, i, 0);
        }

    }

    public static void heapAdjust(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            // 子节点大于父节点 ，交换
            if (list[index] > temp) {
                // 用子节点的值赋值到父节点
                list[k] = list[index];
                //
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {16, 5, 1, 56, 18, 7, 6, 99};
        heapSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
