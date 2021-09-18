package LC100Collection.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 */

public class xie23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public static void main(String[] args) {
//        ListNode[] lists = new ListNode[]{
//                new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(1, new ListNode(3, new ListNode(4))),
//                new ListNode(2, new ListNode(6))
//        };
        ListNode[] listNodes = new ListNode[]{null};
//        for (ListNode list : lists) System.out.println(Arrays.toString(xie2.format(list)));
        System.out.println(Arrays.toString(xie2.format(mergeKLists(listNodes))));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        int k = lists.length;
        ListNode dummy = new ListNode(-1), ans = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < k; i++) if (lists[i] != null) q.add(lists[i]);
        while (!q.isEmpty()) {
            ListNode poll = q.poll();
            ans.next = new ListNode(poll.val);
            ans = ans.next;
            if (poll.next != null) q.add(poll.next);
        }
        return dummy.next;
    }
}
