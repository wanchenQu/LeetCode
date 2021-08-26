package LC100Collection.DP;

/**
 * 爬楼梯
 */
public class xie70 {
    public static void main(String[] args) {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         * 注意：给定 n 是一个正整数。
         * */
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
