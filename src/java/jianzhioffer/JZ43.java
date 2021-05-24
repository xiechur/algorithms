//package jianzhioffer;
//
//
///**
// * 剑指 Offer 43. 1～n 整数中 1 出现的次数
// * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
// *
// * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
// *
// *
// *
// * 示例 1：
// *
// * 输入：n = 12
// * 输出：5
// * 示例 2：
// *
// * 输入：n = 13
// * 输出：6
// *
// * 限制：
// *
// * 1 <= n < 2^31
// */
//public class JZ43 {
//
//    public int countDigitOne(int n) {
//
//        int base = 1;
//        int before = 0;
//        int curr = n;
//        int res = 0;
//        while (curr > 0) {
//            int key = curr%10;
//            if(key == 1) {
//
//            } else if (key > 1) {
//
//            }
//        }
//    }
//
//    /**
//     * n = 234 arr={4,3,2} i是十进进制位数
//     * 状态：dp[i] 代表了 当前前num[i]个组成的数值  的1的个数
//     * 方程：dp[i] = dp[i-1]
//     *      i == 0时，dp[0] = nums[0] >= 1 ?1:0
//     *      i > 0
//     *          num[i] == 0, dp[i] = dp[i-1]
//     *          num[i] == 1,
//     *              dp[i] = dp[i-1] + num[i-1]+1
//     *          num[i] > 1,
//     *              dp[i] = dp[i-1] + (num[i]) + (10 ^ i)
//     *
//     *
//     * @param arr
//     * @return
//     */
//    public int countDigitOne(int[] arr) {
//
//
//
//      return 0;
//
//
//    }
//
//
//    public static void main(String[] args) {
//        JZ43 jz = new JZ43();
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        int res = jz.countDigitOne(arr);
//        System.out.println(res);
//    }
//
//}
//
