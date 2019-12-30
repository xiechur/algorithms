package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagrams {


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();

        char[] ch1 =s.toCharArray();
        char[] ch2 =p.toCharArray();
        int[] arr = new int[26];
        //
        for (int i = 0; i < ch2.length; i++) {
            arr[ch2[i]-'a'] ++;
        }
        // from index 0
        for (int i = 0; i <= ch1.length - ch2.length; i++) {
            boolean match = true;
            int[] temp = new int[26];
            for (int k = i; k < i + ch2.length; k++) {
                temp[ch2[k]-'a'] ++;
            }
            // compare temp,arr
            for (int l = 0; l < arr.length;l++) {
                if (temp[l] != arr[l]) {
                    match = false;
                    break;
                }
            }
            if (isSame(temp, arr)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSame(int[] arr1,int[] arr2){
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String p = "cfc";
        char[] ch2 =p.toCharArray();
        char[] ch1 =p.toCharArray();
        int[] letterChar = new int[26];
//        for (int i = 0; i < ch2.length; i++) {
//            letterChar[ch2[i]-'a'] ++;
//        }
        System.out.println(ch1==ch2);
        System.out.println(ch1.equals(ch2));
        for (int i = 0;i< ch1.length;i++) {
            if (ch1[i]-ch2[i] == 0) {

            } else {

            }
        }


    }



}
