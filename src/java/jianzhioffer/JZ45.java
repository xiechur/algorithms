package jianzhioffer;


/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 */
public class JZ45 {

    /**
     * 可以转化为排序题
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] arr = new String[nums.length];
        for (int i = 0;i < nums.length;i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        quick(arr,0,arr.length-1);
        StringBuilder sb = new StringBuilder();
        for (String s:arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void quick(String[] arr ,int left,int right) {
        if (left< right) {
            int partition = partition(arr,left,right);
            quick(arr,left,partition-1);
            quick(arr,partition+1,right);
        }
    }


    private static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    private int partition(String[] arr ,int left,int right) {
        while(left < right) {
            String temp = arr[left];
            while(left < right && (arr[right]+temp).compareTo(temp+arr[right])>=0) {
                right--;
            }
            swap(arr,left,right);
            while(left < right && (arr[left]+temp).compareTo(temp+arr[left])<=0) {
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }



    public static void main(String[] args) {
        JZ45 jz = new JZ45();
        int[] arr = {3,30,34,5,9};
        String res = jz.minNumber(arr);
        System.out.println(res);

        System.out.println("303".compareTo("330"));
    }

}

