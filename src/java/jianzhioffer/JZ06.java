package jianzhioffer;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 通过次数216,297提交次数2
 */
public class JZ06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0 ;i < size;i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    public static void main(String[] args) {


    }

}
