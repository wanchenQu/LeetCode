package LC100Collection.DP;

import java.util.Arrays;

/**
 * 戳气球
 */
public class xie312 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] _nums) {
        int n = _nums.length;
        int[] nums = new int[n + 2];
        for (int i = 1; i <= n; i++) nums[i] = _nums[i - 1];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int cur = dp[i][k] + dp[k][j] + nums[i] * nums[j] * nums[k];
                    dp[i][j] = Math.max(dp[i][j], cur);
                }
            }
        }
        return dp[0][n + 1];
    }
}
