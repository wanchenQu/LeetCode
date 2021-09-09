package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 二叉树展开为链表
 */

public class xie114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(5,
                        null,
                        new TreeNode(6)
                )
        );
        System.out.println(xie102.levelOrder(root));
        flatten(root);
        System.out.println(xie102.levelOrder(root));

    }

    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode l = root.left;
                while (l.right != null) l = l.right;
                l.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
