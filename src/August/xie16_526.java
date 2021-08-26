package August;

/**
 * 优美的排列
 */

public class xie16_526 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(countArrangement(n));
    }

    public static int countArrangement(int n) {
        int status = 1 << n;
        int[][] dp = new int[n + 1][status];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 枚举所有可能状态
            for (int j = 0; j < status; j++) {
                // 检查所有状态的可能位置是否合法:第k位置
                for (int k = 1; k <= n; k++) {
                    // 如果当前状态的k位置未被选择，直接跳过
                    if ((j >> k - 1 & 1) == 0) continue;
                    // 非法位置
                    if (i % k != 0 && k % i != 0) continue;
                    dp[i][j] += dp[i - 1][j & ~(1 << k - 1)];
                }
            }
        }
        return dp[n][status - 1];
    }

}
