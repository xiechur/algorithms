package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 

提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

 */
public class Q019 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static ListNode removeNthFromEnd(ListNode head, int n)  {
        ListNode res = null;
        if (head == null) {
            return  null;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        if (n > len) {
            return null;
        }
        int i = 0;
        while (i >= n) {
            i++;
        }
        return res.next;
    }


    public static ListNode removeNthFromEnd2(ListNode head, int n)  {
        ListNode res = null;
        if (head == null) {
            return  null;
        }
        Deque deque = new LinkedList();

        return res.next;
    }



    public static void main(String[] args) {
        int [] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
    }

}