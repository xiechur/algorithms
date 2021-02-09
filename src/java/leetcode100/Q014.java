package leetcode100;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

 

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 

提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
 */
public class Q014 {

    // 1.遍历法 时间复杂度 O(mn) m:strs平均长度 n:strs个数
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0 ) {
            return "";
        }
        String res = strs[0];
        for (int i = 1;i < strs.length;i++) {
            res = longestCommonPrefix(res,strs[i]);
        }
        return res;
    }

    private static String longestCommonPrefix(String a,String b) {
        int index = 0;
        int length = Math.min(a.length(),b.length());
        while (index < length && a.charAt(index) == b.charAt(index)) {
            index++;
        }
        return a.substring(0,index);
    }


    public static void main(String[] args) {
    }

}