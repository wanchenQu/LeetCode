package LC100Collection.DP;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class xie309 {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
         *
         * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
         *
         * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
         * */
        int[] ps = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(ps));
    }

    public static int maxProfit(int[] ps) {
        int len = ps.length;
        if (len < 2) return 0;
        int[][] dp = new int[2][3];
        dp[0][1] = -ps[0];
        for (int i = 1; i < len; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][2]);
            dp[i & 1][1] = Math.max(dp[(i - 1) & 1][0] - ps[i], dp[(i - 1) & 1][1]);
            dp[i & 1][2] = dp[(i - 1) & 1][1] + ps[i];
        }
        return Math.max(dp[(len - 1) & 1][0], dp[(len - 1) & 1][2]);
    }
}
