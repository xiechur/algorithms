package leetcode100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 */
public class Q032 {


    // 栈
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i =0;i < s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }

    /**
     *  动态规划
     *  1.阶段
     *  2.状态
     *  3.最优值
     *  4.边界
     *  表达式
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        return 0;
    }

    public static void main(String[] args) {

    }

}
