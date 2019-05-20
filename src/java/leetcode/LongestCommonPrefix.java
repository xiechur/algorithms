package java.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        int length =strs[0].length();
        for (int i = 0; i < strs.length;i++) {
            int l = strs[i].length();
            if(l < length) {
                length = l;
                index = i;
            }
        }

        String temp = strs[index];
        for(int i = 0; i < strs.length;i++) {
            while(strs[i].indexOf(temp)!=0) {
                temp = temp.substring(0,temp.length()-1);
            }
        }
        return temp;

    }
}
