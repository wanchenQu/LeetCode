package August;

/**
 * 获取生成数组中的最大值
 */

public class xie23_1646 {
    public static void main(String[] args) {
        /**
         * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
         * nums[0] = 0
         * nums[1] = 1
         * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
         * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
         * 返回生成数组 nums 中的 最大 值。
         * */
        System.out.println(getMaximumGenerated(2));
    }

    public static int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int ans = 0;
        int[] dp = new int[n + 1];
        dp[1] = ans = 1;
        for (int i = 2; i <= n; i++) {
            int m = i >> 1;
            if ((i & 1) == 1) dp[i] = dp[m] + dp[m + 1];
            else dp[i] = dp[m];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
