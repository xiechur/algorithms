package leetcode100;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。

 */
public class Q017 {


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        List<String> combinations = new ArrayList<>();
        final Map<Character,String[]> map = new HashMap<Character,String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        // 23 ->>>  ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        Queue<String> queue = new LinkedList<>();
        for (int i = 0;i < digits.length();i++) {
            char ch = digits.charAt(i);
            String[] strs = map.get(ch);
            if (queue.size() == 0) {
                for (String letter : strs) {
                    queue.add(letter);
                }
            } else {
                int queueLength = queue.size();
                for (int j = 0 ;j < queueLength;j++) {
                    String s = queue.poll();
                    for (String letter:strs) {
                        queue.add(s+letter);
                    }
                }
            }
        }
        for (String s:queue) {
            combinations.add(s);
        }
        return combinations;
    }

    private List<String> letterCombinations2(String digits) {
        List<String> res=  new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        final Map<Character,String[]> map = new HashMap<Character,String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        backtrack(res,digits,map,sb,0);
        return res;
    }


    private void backtrack(List<String> res,String digits, Map<Character, String[]> phoneMap,StringBuffer sb,int index) {
        // 终止条件
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        String[] phoneArr = phoneMap.get(ch);

        for (String s :phoneArr ) {
            // 选中
            sb.append(phoneArr);
            // 下一层
            backtrack(res,digits,phoneMap,sb,index+1);
            // 撤销
            sb.deleteCharAt(sb.length()-1);
        }

    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
        Q017 q = new Q017();
        List<String>  res= q.letterCombinations2("23");
        for (String s:res) {
            System.out.println(s);
        }
    }

}