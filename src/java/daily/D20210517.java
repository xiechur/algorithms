package daily;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 */
public class D20210517 {


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

    /**
     * 父节点不同，深度相同
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {

        TreeNode px = null,py = null;//父节点
        int dx = 0,dy  =0;// 深度
        int h = 0;//
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // 当前层数的节点数量
            int len = q.size();
            for(int i = len; i > 0; i--){
                TreeNode node = q.poll();

                if (node.left != null) {
                    int val = node.left.val;
                    if(val == x) {
                        dx = h+1;
                        px = node;
                    } else if(val == y){
                        dy = h+1;
                        py = node;
                    }
                    q.offer(node.left);
                }
                if (node.right != null) {
                    int val = node.right.val;
                    if(val == x) {
                        dx = h+1;
                        px = node;
                    } else if(val == y){
                        dy = h+1;
                        py = node;
                    }
                    q.offer(node.right);
                }
            }
            h++;
        }
        return dx == dy && px != py;
    }

}
