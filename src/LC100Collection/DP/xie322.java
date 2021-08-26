package LC100Collection.DP;

import java.util.Arrays;

/**
 * 零钱兑换
 */

public class xie322 {
    public static void main(String[] args) {
        /**
         * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
         * 你可以认为每种硬币的数量是无限的。
         * */
        int[] coins = new int[]{1};
        int amount = 0;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // dp[i] = MIN{coin : coins} dp[i - coin] + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }

}
