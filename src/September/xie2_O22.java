package September;

import June.ListNode;

/**
 * 链表中倒数第k个节点
 */

public class xie2_O22 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int k = 2;
        System.out.println(getKthFromEnd(node1, k).val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = head;
        for (int i = 0; i < k; i++) dummy = dummy.next;
        while (dummy != null) {
            dummy = dummy.next;
            head = head.next;
        }
        return head;
    }
}
