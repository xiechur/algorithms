package jianzhioffer;


/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class JZ24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 迭代
     * 时间复杂度：O(n)O(n)，其中 nn 是链表的长度。需要遍历链表一次。
     *
     * 空间复杂度：O(1)O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 判空
        if (head == null|| head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 是链表的长度。需要对链表的每个节点进行反转操作。
     *
     * 空间复杂度：O(n)O(n)，其中 nn 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 nn 层。
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // 判空
        if (head == null|| head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }


}
