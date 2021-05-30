package leetcode100;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Q148 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        ListNode rightNode = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return mergeTwoList(left,right);

    }


    private ListNode midNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode h = new ListNode(0);
        ListNode curr = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;

            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return h.next;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = length(head);
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {

            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode l1 = curr;
                for (int  i = 1;i < subLength && curr != null&& curr.next != null;i++) {
                    curr = curr.next;
                }
                ListNode l2 = curr.next;
                curr.next = null;
                curr = l2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merge = mergeTwoList(l1,l2);
                prev.next = merge;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    private int length(ListNode head) {
        ListNode curr = head;
        int res = 0;
        while (curr != null) {
            res++;
            curr = curr.next;
        }
        return res;
    }


}
