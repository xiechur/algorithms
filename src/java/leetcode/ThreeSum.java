package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiechurong
 * @Date 2019/12/30
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] a = new int[6];
        threeSum.threeSum(a);
    }

    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length >= 3) {
            int sum = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j-1]) j++;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    } else if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
