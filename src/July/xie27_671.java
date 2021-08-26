package July;

/**
 * 二叉树中第二小的节点
 */
public class xie27_671 {
    static int ans = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(2),
                new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    static void dfs(TreeNode root, int cur) {
        if (root == null) return;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
