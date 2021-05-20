package jianzhioffer;


/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class JZ12 {

    /**
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 判空
        if (board == null || board.length == 0||board[0].length == 0|| word == null) {
            return false;
        }
        char[] words = word.toCharArray();
        int k = 0;
        for (int i =0;i< board.length;i++) {
            for (int j =0;i< board[0].length;j++) {
                if (board[i][j] == word.charAt(k)) {
                     if (dfs(board,words,i,j,0)) {
                         return true;
                     }
                }
            }
        }
        return false;
    }



    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }


    public static void main(String[] args) {
        JZ12 jz = new JZ12();
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean b = jz.exist(arr,"ABCCED");
        System.out.println(b);

    }

}
