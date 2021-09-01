package LC100Collection.tree;

import xieTest.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */

public class xie102 {

    public static void main(String[] args) {
        /**
         * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
         * （即逐层地，从左到右访问所有节点）。
         * */
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        System.out.println(levelOrder(null));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = q.poll();
                cur.add(poll.val);
                if (poll.left != null) q.add(poll.left);
                if (poll.right != null) q.add(poll.right);
            }
            ans.add(cur);
        }
        return ans;
    }
}
