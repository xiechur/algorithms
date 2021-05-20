package leetcode100;

import java.util.ArrayList;
import java.util.List;

/*
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class Q022 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0,0,n,new StringBuilder(),res);
        return res;
    }

    /**
     *
     * @param l  已用的左括号个数
     * @param r 已用的右括号个数
     * @param n
     * @param str
     * @param result
     */
    public static void dfs(int l,int r,int n, StringBuilder str,List<String> result) {
        if(str.length() == n*2) {
            result.add(str.toString());
            return;
        }
        if(l<n) {
            str.append("(");
            dfs(l+1, r, n, str, result);
            str.deleteCharAt(str.length()-1);
        }
        if(r<l) {
            str.append(")");
            dfs(l, r+1, n, str, result);
            str.deleteCharAt(str.length()-1);
        }
    }


    public static void main(String[] args) {

        List<String> result = generateParenthesis(3);
        for (String string : result) {
            System.out.println(string);
        }
    }

}
