package jianzhioffer;


import leetcode.AddTwoNumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class JZ40 {

    /**
     * 排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 优先队列堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i : arr) {
            queue.offer(i);
        }

        for (int i = 0;i < k;i++) {
            res[i] = queue.poll();
        }
        return res;
    }


    /**
     * 堆排序
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        // 定义初始堆k各元素
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        // 1.构造大顶堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapAdjust(res, k, i);
        }
        for (int i = k;i < arr.length;i++) {
            if (arr[i] < res[0]) { // 如果当前元素小于堆顶，替换调整堆
                res[0] = arr[i];
                heapAdjust(res,res.length, 0);
            }

        }
        return res;
    }


    /**
     * 计数排序
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers4(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        int[] counter = new int[10001];
        for (int i:arr) {
            counter[i]++;
        }
        int idx = 0;
        for (int num =0;num < counter.length;num++) {
            if (counter[num] > 0) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }


    /**
     * 快速
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers5(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        return quickSort2(arr,0,arr.length-1,k-1);
    }



    public int[] quickSort2(int[] arr, int left, int right,int k) {
        int partition = partition(arr, left, right);
        if (partition == k) {
            return Arrays.copyOf(arr,partition+1);
        } else if (partition > k){
            return quickSort2(arr,left,partition-1,k);
        } else {
            return quickSort2(arr,partition+1,right,k);
        }
    }


    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            while (left < right && arr[right] >= temp) {
                right--;

            }
            swap(arr, left, right);
            while (left < right && arr[left] <= temp) {
                left++;

            }
            swap(arr, left, right);
        }
        return left;
    }

    public void heapSort(int[] list) {
        // 1.构造大顶堆
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            heapAdjust(list, list.length, i);
        }
        // 排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            swap(list, i, 0);
            heapAdjust(list, i, 0);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void heapAdjust(int[] arr, int len, int i) {
        int temp = arr[i];
        // 子节点
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            // 左节点与右节点
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            // 与父节点判断
            if (arr[k] > temp) {
                // 父节点交换到
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }


    public static void main(String[] args) {
        JZ40 jz = new JZ40();
        int[] arr = {10, 1, 2, 7, 6, 3, 5};
//        jz.quickSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        int[] res = jz.getLeastNumbers5(arr,4);
        for (int i : res) {
            System.out.println(i);
        }

    }

}

