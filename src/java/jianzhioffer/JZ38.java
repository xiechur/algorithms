package jianzhioffer;



import javafx.beans.binding.StringBinding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
public class JZ38 {


    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        boolean[] used = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        dfs(ch,sb,used);
        return res.toArray(new String[res.size()]);
    }


    /**
     * 递归解法
     * @param ch
     * @param n
     */
    void dfs(char[] ch ,StringBuilder sb,boolean[] used) {
        // 终止条件
        if (sb.length() == ch.length) {
            res.add(sb.toString());
        }
        // 选择列表
        for (int i= 0;i < ch.length;i++) {
            // 剪枝
            if (used[i]) {
                continue;
            }

            // 选择
            sb.append(ch[i]);
            // 更新标记
            used[i] = true;

            // 进入下一层
            dfs(ch,sb,used);

            // 撤销选择
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
    }


    /**
     * 非递归解法：利用栈实现
     * @param ch
     * @param n
     */
//    void dfs2(char[] ch ,int n) {
//
//        Stack<Character> stack = new Stack<>();
//        stack.push(1);
//        while (!stack.isEmpty()) {
//            stack
//        }
//
//        // 终止条件
//        // 遍历当前节点的所有情况
//        //
//        // 满足约束条件与限界条件
//        //
//    }


    public static void main(String[] args) {

    }

}

