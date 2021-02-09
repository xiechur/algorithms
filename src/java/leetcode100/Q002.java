package leetcode100;

/**
 * 两数加法
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * @author xiechurong
 * @Date 2021/1/22
 */
public class Q002 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        // 进位
        int offset = 0;
        while (l1 != null ||l2 != null) {
            int a = l1 != null?l1.val:0;
            int b = l2 != null?l2.val:0;
            int sum = a + b + offset;
            offset = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (offset != 0) {
            cur.next = new ListNode(offset);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode s = addTwoNumbers(l1, l2);
        while (s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }
}
