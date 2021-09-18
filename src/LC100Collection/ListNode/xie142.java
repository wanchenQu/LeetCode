package LC100Collection.ListNode;

/**
 * 环形链表2
 */

public class xie142 {
    public static void main(String[] args) {
        /**给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。*/
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node5;
        System.out.println(detectCycle(node1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
