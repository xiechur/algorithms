//package jianzhioffer;
//
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 剑指 Offer 35. 复杂链表的复制
// * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
// *
// * 示例 1：
// *
// * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// * 示例 2：
// *
// * 输入：head = [[1,1],[2,1]]
// * 输出：[[1,1],[2,1]]
// * 示例 3：
// *
// * 输入：head = [[3,null],[3,0],[3,null]]
// * 输出：[[3,null],[3,0],[3,null]]
// * 示例 4：
// *
// * 输入：head = []
// * 输出：[]
// * 解释：给定的链表为空（空指针），因此返回 null。
// *
// * 提示：
// *
// * -10000 <= Node.val <= 10000
// * Node.random 为空（null）或指向链表中的节点。
// * 节点数目不超过 1000 。
// *
// */
//public class JZ35 {
//
//    public class Node {
//        int val;
//        Node next;
//        Node random;
//
//
//        public Node(int val) {
//            this.val = val;
//        }
//
//        Node(int val, Node next, Node random) {
//            this.val = val;
//            this.next = next;
//            this.random = random;
//        }
//    }
//
//
//
//    public Node copyRandomList(Node head) {
//
//        Node curr = head;
//        Node dum  = new Node(0);
//        Node pre = dum;
//        Map<Node, Node> map = new HashMap<>();
//        while (curr != null) {
//            map.put(curr,new Node(curr.val) );
//            curr = curr.next;
//        }
//        curr = head;
//        while (curr != null) {
//            Node node = map.get(curr.next);
//            pre.next = node;
//            pre.random = map.get(curr.random);
//            curr = curr.next;
//            pre = node;
//        }
//        return dum.next;
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
//
