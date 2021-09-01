package LC100Collection.tree;

import xieTest.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */

public class xie94 {
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),
                        null)
        );
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    static void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }
}
