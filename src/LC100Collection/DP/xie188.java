package LC100Collection.DP;

/**
 * 买卖股票的最佳时机4
 */
public class xie188 {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
         * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
         * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         * */
        int k = 2;
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len < 2) return 0;
        if (k >= len >> 1) return sp(prices);
        // dp数组定义: dp[i][j][k] 第i天, j次买入, 持股状态为k 的手头资金
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) dp[i][1] = Integer.MIN_VALUE;
        for (int p : prices) {
            for (int j = k; j >= 1; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + p);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - p);
            }
        }
        return dp[k][0];
    }

    // 特殊情况解， 如果k >= prices.len / 2 说明可以无限制交易次数
    static int sp(int[] ps) {
        int ans = 0, def;
        for (int i = 1; i < ps.length; i++) {
            def = ps[i] - ps[i - 1];
            ans += Math.max(def, 0);
        }
        return ans;
    }

}
