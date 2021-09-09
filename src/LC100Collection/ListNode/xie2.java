package LC100Collection.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两数相加
 */

public class xie2 {
    public static void main(String[] args) {
        /**
         * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
         * 请你将两个数相加，并以相同形式返回一个表示和的链表。
         * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
         * */
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode node3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode node4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(Arrays.toString(format(addTwoNumbers(node1, node2))));
        System.out.println(Arrays.toString(format(addTwoNumbers(node4, node3))));

    }

    public static int[] format(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 每个链表中的节点数在范围 [1, 100] 内
         * 0 <= Node.val <= 9
         * 题目数据保证列表表示的数字不含前导零
         * */
        int carry = 0, curSum = 0;
        ListNode dummy = new ListNode(-1), tmp = dummy;
        while (l1 != null || l2 != null) {
            curSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = curSum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            tmp.next = new ListNode(curSum % 10);
            tmp = tmp.next;
        }
        if (carry != 0) tmp.next = new ListNode(carry);
        return dummy.next;
    }

}
