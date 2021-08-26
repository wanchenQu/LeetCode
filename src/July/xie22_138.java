package July;

/**
 * 复制带随机指针的链表
 */
public class xie22_138 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = null;
        node3.random = node2;
        System.out.println(copyRandomList(node1));
    }

    public static Node copyRandomList(Node head) {
        Node p = new Node(-1);
        p.next = head;
        while (p != null) {
            Node temp = new Node(p.val);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}
