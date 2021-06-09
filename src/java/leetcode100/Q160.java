package leetcode100;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class Q160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 双指针
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null|| headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1 != l2) {
            l1 = l1 != null?l1.next:headB;
            l2 = l2 != null?l2.next:headA;
        }
        return l1;
    }


    /**
     * hash set
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null|| headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
