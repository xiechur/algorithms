package leetcode100;

import java.util.*;

/**
 * 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class Q890 {


    /**
     * 分析：
     * 匹配函数：word与pattern进行每个字母进行映射，使用HashMap进行存储映射关系
     * 如：abb 与 ccc 需要进行反向匹配
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(pattern, word) && match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }


    /**
     * 匹配
     * mee 与 abb 进行匹配
     *
     * @return
     */
    public boolean match(String pattern, String word) {
        // 判空，长度判断
        if (word != null && pattern != null && word.length() == pattern.length()) {
            char[] arr1 = word.toCharArray();
            char[] arr2 = pattern.toCharArray();
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < arr1.length; i++) {
                if (map.containsKey(arr1[i])) {
                    // 获取value,判断是否与arr2[i}相等
                    if (arr2[i] != map.get(arr1[i])) {
                        return false;
                    }
                } else {
                    // 将arr2[i] put value
                    map.put(arr1[i], arr2[i]);
                }
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Q890 q890 = new Q890();
        List<String> res = q890.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb");
        System.out.println(res.size());
    }

}

