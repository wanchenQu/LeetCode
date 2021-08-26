package LC100Collection.DP;

/**
 * 买卖股票的最佳时机含手续费
 */
public class xie714 {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
         * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，
         * 在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
         * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付【一次】手续费。
         * */
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[2][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], dp[(i - 1) & 1][0] - prices[i]);
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1] + prices[i] - fee);
        }
        return dp[(len - 1) & 1][0];
    }
}
