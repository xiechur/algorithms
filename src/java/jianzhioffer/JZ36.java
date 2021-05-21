package jianzhioffer;


import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

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
public class JZ36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    Node pre = null,head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }


    void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        dfs(curr.left);
        if (pre == null) {
            head = curr;
            pre = head;
        } else {
            pre.right = curr;
            curr.left = pre;
            pre = curr;
        }
        dfs(curr.right);
    }



    public static void main(String[] args) {

    }

}

