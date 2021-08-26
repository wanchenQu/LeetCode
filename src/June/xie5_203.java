package June;

import javax.swing.*;

/**
 * 移除链表元素
 */
public class xie5_203 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        printListNode(node1);
        solution(node1, 6);
        printListNode(node1);
    }

    public static ListNode solution(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        dfs(dummy, dummy.next, val);
        return dummy.next;
    }

    private static void dfs(ListNode prev, ListNode current, int val) {
        if (current == null) {
            return;
        }
        if (current.val == val) {
            prev.next = current.next;
        } else {
            prev = current;
        }
        dfs(prev, current.next, val);
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
