package leetcode100;

import java.util.*;

/**
 * 1051. 高度检查器
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 *
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 *
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 *
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 *
 *
 * 示例：
 *
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 * 示例 2：
 *
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 解释：
 * 高度：[5,1,2,3,4]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都不匹配。
 * 示例 3：
 *
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 高度：[1,2,3,4,5]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都匹配。
 *
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class Q1051 {


    /**
     * 分析：
     * 1.复制到新的数组
     * 2.原数组进行排序
     * 3.遍历计算
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0;i < heights.length;i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0;i < heights.length;i++) {
            if (arr[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }




    public static void main(String[] args) {
        Q1051 q = new Q1051();
        int res = q.heightChecker(new int[]{3,1,2,4,5,6});
        System.out.println(res);
    }

}

