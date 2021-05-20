package leetcode100;

import sort.HeapSort;

import java.util.Deque;
import java.util.LinkedList;

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 */
public class Q021 {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)  {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null & l2 != null){
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return res.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2)  {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return prehead.next;

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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        r1.next = r2;
        r2.next = r3;
        r3.next = null;

        ListNode result = mergeTwoLists2(l1, r1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}