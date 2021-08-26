package June;

/**
 * 盈利计划
 */
public class xie9_879 {
    public static void main(String[] args) {
        // n名员工，完成工作创造利润
        // 工作i需要group[]的人工来创造profit[i]的利润
        // 工作至少产生minProfit利润的子集称为盈利计划
        int n = 5;
        int minProfit = 3;
        int[] group = new int[]{2, 2};
        int[] profit = new int[]{2, 3};
        System.out.println(solution(n, minProfit, group, profit));
    }

    public static int solution(int n, int minProfit, int[] group, int[] profit) {
        // dp[i][j][k]数组定义：前i个任务，动用人工<=j，创造利润>=k的方案数
        // 状态转移方程：dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][max{0, k - profit[i - 1]}]
        int MOD = (int) 1e9 + 7;
        int len = group.length;
        int[][] dp = new int[n + 1][minProfit + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int a = group[i - 1];
            int b = profit[i - 1];
            for (int j = n; j >= a; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - a][Math.max(0, k - b)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
