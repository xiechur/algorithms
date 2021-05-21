package jianzhioffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class JZ34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res =new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root,target,path,res);
        return res;
    }


    void dfs(TreeNode node,int tar,LinkedList<Integer> path,List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        // 放进路径中，
        path.add(node.val);
        tar = tar-node.val;
        // 符合条件，
        if (tar == 0 && node.left == null && node.right == null) {
            res.add(new LinkedList<>(path));
        }
        dfs(node.left,tar,path,res);
        dfs(node.right,tar,path,res);
        path.removeLast();
    }



    public static void main(String[] args) {

    }

}

