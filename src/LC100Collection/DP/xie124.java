package LC100Collection.DP;

import xieTest.TreeNode;

/**
 * 二叉树中的最大路径和
 */

public class xie124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15,
                                new TreeNode(6), null),
                        new TreeNode(7,
                                new TreeNode(4),
                                new TreeNode(6)
                        )
                )
        );
        System.out.println(maxPathSum(root));
    }
    static int ans = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    static int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = Math.max(0, dfs(node.left));
        int r = Math.max(0, dfs(node.right));
        int cur = node.val+ l+ r;
        ans = Math.max(ans, cur);
        return node.val + Math.max(l, r);
    }

}
