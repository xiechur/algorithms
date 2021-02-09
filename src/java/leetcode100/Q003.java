package leetcode100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Q003 {

    // 1.暴力法 : 遍历所有的子串，然后找出最长的不含重复字符的长度
    // 时间复杂度：O(n^3)
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i >= maxLen && allUnique(s.substring(i, j))) {
                    maxLen = j - i;
                }
            }
        }
        return maxLen;
    }

    // 2.滑动窗口 i与j 从左到右滑动
    // 时间复杂度：O(n)
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLen = 0;
        int i = 0, j = 0;
        String maxStr = "";
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                if (j - i > maxLen) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
    // 3.滑动窗口 i与j 从左到右滑动 如果s[j]在子字符串[i,j-1)范围内与s[j]重复，我们不需要逐渐增加i，直接调到j+1开始
    // 时间复杂：O(n)
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int maxLen = 0;
        String maxStr = "";
        Map<Character, Integer> map = new HashMap<>();
        int i =0,j =0;
        for (i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1,i );
            }
            if (j-i+1>maxLen) {
                maxLen = j-i+1;
                maxStr = s.substring(i, j + 1);
            }
            map.put(s.charAt(j), j);
        }
        return maxLen;
    }

    //4.

    private static boolean allUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "abcabcdnnabcdefghjkl";
        System.out.println(lengthOfLongestSubstring1(string));
        System.out.println(lengthOfLongestSubstring2(string));
        System.out.println(lengthOfLongestSubstring3(string));
    }

}
