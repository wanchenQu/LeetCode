package LC100Collection.DP;

/**
 * 买卖股票的最佳时机
 */
public class xie121 {
    /**
     * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // dp数组定义：dp[i][j]: 第i天，持股状态为j[0, 1]的情况下手中的资金状态
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][1] + prices[i], dp[(i - 1) & 1][0]);
            dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], -prices[i]);
        }
        return dp[(n - 1) & 1][0];
    }
}

