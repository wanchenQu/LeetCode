package LC100Collection.ListNode;

import java.util.Arrays;

/**
 * 删除链表的倒数第 N 个结点
 */

public class xie19 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode node2 = new ListNode(1, new ListNode(2));
        int n2 = 1;

        System.out.println(Arrays.toString(xie2.format(node2)));
        System.out.println(Arrays.toString(xie2.format(removeNthFromEnd(node2, n2))));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), fast = dummy, slow = dummy;
        while (n-- >= 0) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
