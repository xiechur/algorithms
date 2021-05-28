package jianzhioffer;


/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class JZ42 {

    /**
     * 动态规划：某阶段某状态下的最优解
     * 状态： dp[i]代表元素nums[i]结尾的数组的最大和
     * 方程：dp[i] = dp[i-1]> 0 ? dp[i-1] + nums[i]:nums[i]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0;i < dp.length;i++) {
            if (dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        JZ42 jz = new JZ42();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = jz.maxSubArray(arr);
        System.out.println(res);
    }

}

