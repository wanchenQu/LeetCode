package xieTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历
 */
public class xie102 {

    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode node2 = null;
        System.out.println(levelOrder(node1).toString());
        System.out.println(levelOrderDFS(node1).toString());
    }

    // bfs
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = dq.pollFirst();
                cur.add(temp.val);
                if (temp.left != null) {
                    dq.addLast(temp.left);
                }
                if (temp.right != null) {
                    dq.addLast(temp.right);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    // dfs
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        return ans;
    }

    static void dfs(TreeNode node, int depth) {
        if (depth > ans.size() - 1) {
            List<Integer> cur = new ArrayList<>();
            ans.add(cur);
        }
        ans.get(depth).add(node.val);

        if (node.left != null) {
            dfs(node.left, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
