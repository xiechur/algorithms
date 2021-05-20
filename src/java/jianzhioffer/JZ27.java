package jianzhioffer;


/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * @author xiechurong
 * @Date 2021/5/18
 */
public class JZ27 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode right = mirrorTree(root.right);
            TreeNode left = mirrorTree(root.left);
            root.left = right;
            root.right = left;
        }
        return root;
    }
}
