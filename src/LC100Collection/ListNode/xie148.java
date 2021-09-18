package LC100Collection.ListNode;

import java.util.Arrays;

/**
 * 排序链表
 */

public class xie148 {
    public static void main(String[] args) {
        /**
         *  给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
         *  你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
         */
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode head2 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(Arrays.toString(xie2.format(head2)));
        System.out.println(Arrays.toString(xie2.format(sortList(head2))));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode f = head, s = head;
        // 二分
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode r = s.next;
        s.next = null;
        head = sortList(head);
        r = sortList(r);
        ListNode dummy = new ListNode(-1, head), p = dummy;
        // 归并
        while (head != null && r != null) {
            if (head.val < r.val) {
                p.next = head;
                head = head.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = head != null ? head : r;
        return dummy.next;
    }

}
