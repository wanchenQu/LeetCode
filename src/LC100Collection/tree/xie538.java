package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 */

public class xie538 {
    static int preSum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                null,
                                new TreeNode(3)
                        )
                ),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8)
                        )
                )
        );
        System.out.println(xie102.levelOrder(root));
        System.out.println(xie102.levelOrder(convertBST(root)));
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) dfs(root);
        return root;
    }

    static void dfs(TreeNode root) {
        if (root.right != null) dfs(root.right);
        preSum += root.val;
        root.val = preSum;
        if (root.left != null) dfs(root.left);
    }
}
