package LC100Collection.DP;

/**
 * 买卖股票的最佳时机3
 */
public class xie123 {
    public static void main(String[] args) {
        /**
         * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
         *
         * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
         *
         * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         * */
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // dp数组定义: dp[i][j][k]: 第i天，j[0, 1, 2]次买入动作，持股状态为k[0, 1]的情况下的手中资金
        int n = prices.length;
        int[][][] dp = new int[2][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i & 1][1][1] = Math.max(-prices[i], dp[(i - 1) & 1][1][1]);
            dp[i & 1][1][0] = Math.max(dp[(i - 1) & 1][1][1] + prices[i], dp[(i - 1) & 1][1][0]);
            dp[i & 1][2][1] = Math.max(dp[(i - 1) & 1][1][0] - prices[i], dp[(i - 1) & 1][2][1]);
            dp[i & 1][2][0] = Math.max(dp[(i - 1) & 1][2][1] + prices[i], dp[(i - 1) & 1][2][0]);
        }
        return Math.max(0, Math.max(dp[(n - 1) & 1][1][0], dp[(n - 1) & 1][2][0]));
    }
}
