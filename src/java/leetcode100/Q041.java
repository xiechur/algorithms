package leetcode100;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class Q041 {


    /**
     * hashMap
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] <=0) {
                continue;
            }
            map.put(nums[i],1);
        }
        int res = 1;

        while (true) {
            Integer value = map.get(res);
            if (value != null) {
                res++;
            } else {
                return res;
            }
        }
    }




    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            if (nums[i] <= 0) {
                nums[i] = n+1;
            }
        }
        for (int i = 0;i < n;i++) {
            int num  = Math.abs(nums[i]);
            if (num <= n) {
                // 取反
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i= 0; i < n;i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return n+1;
    }


    private void swap(int[] arr,int a,int b) {
        int  temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            while (nums[i] >0 && nums[i] <=n && nums[nums[i]-1] != nums[i]) {
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i= 0; i < n;i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return n+1;
    }

}

