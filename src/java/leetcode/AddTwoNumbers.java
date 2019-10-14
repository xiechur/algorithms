package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author xiechurong
 * @Date 2019/3/21
 */
public class AddTwoNumbers {

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位加一
        int offset = 0;
        ListNode l = new ListNode(0);
        if (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int c = a + b;
            offset = c / 10;
            l.next = new ListNode(c % 10);
            l = l.next;
            if (l1 != null) {
                l1 = l2.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return l.next;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}

