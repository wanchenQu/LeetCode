package LC100Collection.ListNode;

import java.util.Arrays;

/**
 * 合并两个有序链表
 */

public class xie21 {
    public static void main(String[] args) {
        /**
         * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
         * */
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(Arrays.toString(xie2.format(node1)));
        System.out.println(Arrays.toString(xie2.format(node2)));
        System.out.println(Arrays.toString(xie2.format(mergeTwoLists(node1, node2))));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 两个链表的节点数目范围是 [0, 50]
         * -100 <= Node.val <= 100
         * l1 和 l2 均按 非递减顺序 排列
         * */
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(-1), ans = dummy;
        while (l1 != null || l2 != null) {
            if ((l1 != null ? l1.val : Integer.MAX_VALUE) <= (l2 != null ? l2.val : Integer.MAX_VALUE)) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        return dummy.next;
    }
}
