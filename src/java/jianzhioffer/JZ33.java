package jianzhioffer;


import java.util.Stack;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 *
 *
 */
public class JZ33 {


    /**
     * 左右跟
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        if (postorder.length == 1) {
            return true;
        }
        return recur(postorder,0,postorder.length-1);
    }


    /**
     * 根节点永远大于左子树
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        if (postorder.length == 1) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length-1;i >= 0;i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }






    private boolean recur(int[] postorder,int i,int j) {
        if (i >= j) {
            return true;
        }
        int temp = i;
        while (postorder[temp]<postorder[j]) {
            temp++;
        }
        int m = temp;
        while (postorder[temp]>postorder[j]) {
            temp++;
        }
        return temp == j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }

    public static void main(String[] args) {

    }

}

