package LC100Collection.DP;

/**
 * 买卖股票的最佳时机2
 */
public class xie122 {
    public static void main(String[] args) {
        /**
         * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
         *
         * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
         *
         * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         * */
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
        System.out.println(sp(prices));

    }

    public static int maxProfit(int[] prices) {
        // dp数组定义：dp[i][j]: 第i天，持股状态为j[0, 1]的情况下手中的资金状态
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][1] + prices[i], dp[(i - 1) & 1][0]);
            dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], dp[(i - 1) & 1][0] - prices[i]);
        }
        return dp[(n - 1) & 1][0];
    }

    static int sp(int[] ps) {
        int ans = 0, def = 0;
        for (int i = 1; i < ps.length; i++) {
            def = ps[i] - ps[i - 1];
            ans += def > 0 ? def : 0;
        }
        return ans;
    }
}
