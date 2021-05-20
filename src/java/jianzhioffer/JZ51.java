package jianzhioffer;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 * @author xiechurong
 * @Date 2021/5/17
 */
public class JZ51 {

    public static void main(String[] args) {
        int[] arr =  {1,3,2,3,1};
        int res = mergeSort(arr,0,arr.length-1);
        System.out.println(res);
        for (int i = 0 ;i < arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static int reversePairs(int[] arr) {
        return  mergeSort(arr,0,arr.length-1);
    }


    private static int mergeSort(int[] arr,int left,int right) {
        int mid = (left +right)/2;
        if (left < right) {
            int c1 = mergeSort(arr,left,mid);
            int c2 = mergeSort(arr,mid+1,right);
            if (arr[mid] <= arr[mid+1]) {
                return c1+c2;
            }
            int c3 = mergeAndCount(arr,left,mid,right);
            return c1 + c2 + c3;
        }
        return 0;
    }

    private static int mergeAndCount(int[] arr,int left,int mid,int right) {
        int[] temp= new int[right-left+1];
        // 左数组的第一个
        int i = left;
        // 右数组的第一个
        int j = mid+1;
        // temp下标
        int k = 0;
        // 计数器:当逆序的时候计算
        int count = 0;
        while(i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count+= mid-i+1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将temp赋值到arr
        for (int l = 0;l < temp.length;l++) {
            arr[l+left] = temp[l];
        }
        return count;
    }
}
