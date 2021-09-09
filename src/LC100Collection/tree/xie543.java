package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 二叉树的直径
 */

public class xie543 {
    static int ans = 0;

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        );
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    static int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }

}
