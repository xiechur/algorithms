package jianzhioffer;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class JZ07 {

    /**
     * 前序：根左右  中序：左根右
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inOrderIndex = 0;
        for (int i = 1; i < preorder.length;i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inOrderIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() &&stack.peek().val == inorder[inOrderIndex]) {
                    node = stack.pop();
                    inOrderIndex++;
                }
                node.right =new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        JZ07 jz = new JZ07();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode res = jz.buildTree(preorder,inorder);

        System.out.println(1);
    }

}
