package leetcode100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class Q098 {

   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean inOrder(TreeNode root) {
       int temp = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= temp) {
                return false;
            }
            temp = root.val;
            root = root.right;
        }
        return true;
    }


    private boolean isValidBST(TreeNode node, long lower, long upper) {
       if (node == null) {
           return true;
       }

       if (node.val <= lower || node.val >= upper) {
           return false;
       }
       return isValidBST(node.left,lower,node.val) && isValidBST(node.right,node.val,upper);
    }
}
