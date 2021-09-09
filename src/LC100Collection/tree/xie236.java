package LC100Collection.tree;

import xieTest.TreeNode;

/**
 * 二叉树的最近公共祖先
 */

public class xie236 {
    /**
     * 祖先的定义： 若节点 p 在节点 root 的左（右）子树中，或 p = root ，则称 root 是 p 的祖先。
     * 最近公共祖先的定义： 设节点 root 为节点 p, q 的某公共祖先，若其左子节点 root.left 和右子节点 root.right
     * 都不是 p,q的公共祖先，则称 root 是 “最近的公共祖先” 。
     */
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3,
//                new TreeNode(5,
//                        new TreeNode(6),
//                        new TreeNode(2,
//                                new TreeNode(7),
//                                new TreeNode(4)
//                        )
//                ),
//                new TreeNode(1,
//                        new TreeNode(0),
//                        new TreeNode(8)
//                )
//        );
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(lowestCommonAncestor(node1, node8, node9).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
//        if (l == null && r == null) return null;
//        if (l != null && r != null) return root;
//        if (l == null && r != null) return r;
//        if (l != null && r == null) return l;
        if (l != null && r != null) return root;
        return l == null ? r : l;
    }
}
