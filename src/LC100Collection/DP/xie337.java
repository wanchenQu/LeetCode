package LC100Collection.DP;

import xieTest.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍3
 */
public class xie337 {
    static Map<TreeNode, Integer> dp0 = new HashMap<>();
    static Map<TreeNode, Integer> dp1 = new HashMap<>();

    public static void main(String[] args) {
        /**
         * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
         * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
         * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
         * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
         *
         * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
         * */
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1)));
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(dp0.getOrDefault(root, 0), dp1.getOrDefault(root, 0));
    }

    static void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
        dp1.put(node, dp0.getOrDefault(node.left, 0) + dp0.getOrDefault(node.right, 0) + node.val);
        dp0.put(node, Math.max(dp0.getOrDefault(node.left, 0), dp1.getOrDefault(node.left, 0)) +
                Math.max(dp0.getOrDefault(node.right, 0), dp1.getOrDefault(node.right, 0)));
    }
}
