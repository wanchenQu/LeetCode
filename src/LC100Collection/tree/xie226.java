package LC100Collection.tree;

import xieTest.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 翻转二叉树
 */

public class xie226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );
        System.out.println(xie102.levelOrder(root));
        //System.out.println(xie102.levelOrder(invertTree(root)));
        System.out.println(xie102.levelOrder(invertTree1(root)));

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.pollFirst();
            TreeNode tmp = poll.left;
            poll.left = poll.right;
            poll.right = tmp;
            if (poll.left != null) q.addLast(poll.left);
            if (poll.right != null) q.addLast(poll.right);
        }
        return root;
    }
}