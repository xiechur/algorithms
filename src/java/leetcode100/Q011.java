package leetcode100;

/*
 * 11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class Q011 {
    // 分析：对于height任意两个点i,j (i<j)   得出(Math.min(height[i],height[j]) * j - i)的最大值


    // 1.暴力法 O(n^2)
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    // 2.
    public  static int maxArea2(int[] height) {
        int i = 0,j = height.length-1,max = 0;
        while (i < j) {
            if (height[j] > height[i]) {
                max = Math.max(max,(j-1)*height[i]);
                i++;
            } else {
                max = Math.max(max,(j-1)*height[j]);
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
        System.out.println(maxArea2(a));
    }

}