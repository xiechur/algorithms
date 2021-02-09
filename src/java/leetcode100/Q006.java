package leetcode100;

/** 6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G

 输入: s = "LEETCODEISHIRING", numRows = 5
 输出: "LSEEHEDITORGCN"
 L       S
 E     E H
 E   D   I
 T O     R G
 C       N
 */
public class Q006 {

    // 1.找规律 当numRows = 4, 则index= 0,6,12,   1,5,7,11,   2,4,8,10,   3,9,15
    public static String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int l1 = s.length();
        int a = 2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < l1; j++) {
                if (j % a == i || j % a == (a - j)) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    // 2.

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(convert1(s, numRows));
    }
}
