package LC100Collection.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * 反转链表
 */

public class xie206 {
    public static void main(String[] args) {
        /**
         * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
         * */
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(Arrays.toString(xie2.format(head)));
        //System.out.println(Arrays.toString(xie2.format(reverseList(head))));
        System.out.println(Arrays.toString(xie2.format(reverseList1(head))));
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return ret;

//        ListNode l = head, r = head.next;
//        while (r.next != null) {
//            l = l.next;
//            r = r.next;
//        }
//        l.next = null;
//        r.next = reverseList1(head);
//        return r;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }
}
