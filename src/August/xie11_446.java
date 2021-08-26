package August;

import java.util.HashMap;
import java.util.Map;

/**
 * 等差数列划分-子序列
 */

public class xie11_446 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2000000000, -294967296};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                long dif = (long) nums[i] - nums[j];
                if (dif > Integer.MAX_VALUE || dif < Integer.MIN_VALUE) continue;
                dp[i].put(dif, dp[i].getOrDefault(dif, 0) + dp[j].getOrDefault(dif, 0) + 1);
                if (dp[j].containsKey(dif)) ans += dp[j].get(dif);
            }
        }
        return ans;
    }
}
