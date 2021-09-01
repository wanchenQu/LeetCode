package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 对称二叉树
 */

public class xie101 {
    public static void main(String[] args) {
        /**
         * 给定一个二叉树，检查它是否是镜像对称的。
         * */
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(2,
                        null,
                        new TreeNode(3)
                )
        );
        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    static boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if ((l == null || r == null) || (l.val != r.val)) return false;
        return helper(l.left, r.right) && helper(l.right, r.left);
    }
}
