package June;

/**
 * 零钱兑换2
 */
public class xie10_518 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(solution(coins, amount));
    }

    public static int solution(int[] coins, int amount) {
        // 完全背包问题
        // dp数组定义:dp[i][j]用前i种硬币凑成金额j的方案数
        // 状态转移方程 dp[i][j] = dp[i - 1][j] + SUM{k:1 ~ j/coins[i]}dp[i - 1][j - k * coins[i]]
        // 展开:dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]] + dp[i-1][j-2coins[i]].......
        // dp[i][j-coins[i]] = dp[i-1][j-coins[i]] + dp[i-1][j-2coins[i]] + dp[i-1][j-3coins[i]]......
        // 综上所述：dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin :
                coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
