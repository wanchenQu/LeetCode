package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 验证二叉搜索树
 */

public class xie98 {
    static long pre = Long.MIN_VALUE;

//    public static boolean isValidBST1(TreeNode root) {
//        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    static boolean dfs(TreeNode node, long l, long g) {
//        if (node == null) return true;
//        if (node.val <= l || node.val >= g) return false;
//        return dfs(node.left, l, node.val) && dfs(node.right, node.val, g);
//    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(2147483647);
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(6,
                        new TreeNode(3),
                        new TreeNode(8)
                )
        );
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        /**中序遍历顺序递增*/
        return dfs(root);
    }

    static boolean dfs(TreeNode node) {
        if (node == null) return true;
        if (!dfs(node.left)) {
            return false;
        }
        if (node.val <= pre) return false;
        pre = node.val;
        return dfs(node.right);
    }
}
