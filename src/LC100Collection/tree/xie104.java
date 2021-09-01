package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 二叉树的最大深度
 */

public class xie104 {

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15,
                                null,
                                new TreeNode(8)),
                        new TreeNode(7)
                )
        );
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    static int dfs(TreeNode node, int cur) {
        if (node == null) return cur;
        cur++;
        return Math.max(dfs(node.left, cur), dfs(node.right, cur));
    }
}
