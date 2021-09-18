package LC100Collection.ListNode;

import java.util.Arrays;

/**
 * 回文链表
 */

public class xie234 {
    public static void main(String[] args) {
        /**
         * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
         * */
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(Arrays.toString(xie2.format(head)));
        System.out.println(isPalindrome(head));
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head, l = null, r = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            ListNode tmp = r.next;
            r.next = l;
            l = r;
            r = tmp;
        }
        if (fast != null) slow = slow.next;
        while (slow != null && l != null) {
            if (l.val != slow.val) return false;
            slow = slow.next;
            l = l.next;
        }
        return true;
    }
}
