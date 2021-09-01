package LC100Collection.tree;

/**
 * 不同的二叉搜索树
 */

public class xie96 {
    public static void main(String[] args) {
        /**
         * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
         * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
         * */
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        /**
         * dp[k] = SUMi in {0, k-1} dp[i] * dp[k - 1 - i]
         * */
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
