package xieTest;

/**
 * 不同的二叉搜索树
 */

public class xie96 {
    public static void main(String[] args) {
        /**
         * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
         * 返回满足题意的二叉搜索树的种数。
         * */
        int n = 4;
        System.out.println(numTrees(n));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
