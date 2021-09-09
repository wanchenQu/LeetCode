package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 合并二叉树
 */

public class xie617 {
    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
     * 否则不为NULL 的节点将直接作为新二叉树的节点。
     */
    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1,
//                new TreeNode(3,
//                        new TreeNode(5),
//                        null
//                ),
//                new TreeNode(2)
//        );
//        TreeNode root2 = new TreeNode(2,
//                new TreeNode(1,
//                        null,
//                        new TreeNode(4)
//                ),
//                new TreeNode(3,
//                        null,
//                        new TreeNode(7)
//                )
//        );
        TreeNode root1 = null;
        TreeNode root2 = new TreeNode(1);
        System.out.println(xie102.levelOrder(root1));
        System.out.println(xie102.levelOrder(root2));
        System.out.println(xie102.levelOrder(mergeTrees(root1, root2)));

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        dfs(root1, root2);
        return root1;
    }

    static TreeNode dfs(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == null ? b : a;
        a.val += b.val;
        a.left = dfs(a.left, b.left);
        a.right = dfs(a.right, b.right);
        return a;
    }
}
