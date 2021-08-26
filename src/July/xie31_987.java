package July;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 二叉树的垂序遍历
 */

public class xie31_987 {
    /**
     * int[x, d, v]
     */
    static PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        if (a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });

    public static void main(String[] args) {
        /**
         * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
         * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)
         * 和(row + 1, col + 1) 。树的根结点位于 (0, 0) 。
         * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，
         * 形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
         * 返回二叉树的 垂序遍历 序列。
         * */
        TreeNode root1 =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)));
        TreeNode root2 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)));
        System.out.println(verticalTraversal(root1));
        System.out.println(verticalTraversal(root2));

    }

    public static void dfs(TreeNode root, int[] p) {
        if (root.left != null) {
            int[] tmp = new int[]{p[0] - 1, p[1] + 1, root.left.val};
            q.add(tmp);
            dfs(root.left, tmp);
        }
        if (root.right != null) {
            int[] tmp = new int[]{p[0] + 1, p[1] + 1, root.right.val};
            q.add(tmp);
            dfs(root.right, tmp);
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] rN = new int[]{0, 0, root.val};
        q.add(rN);
        dfs(root, rN);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int[] poll = q.peek();
            while (!q.isEmpty() && q.peek()[0] == poll[0]) tmp.add(q.poll()[2]);
            ans.add(tmp);
        }
        return ans;
    }
}
