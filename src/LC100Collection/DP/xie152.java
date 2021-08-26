package LC100Collection.DP;

import java.util.Arrays;

/**
 * 成绩最大子数组
 */

public class xie152 {
    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
         * */
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxPre, maxCur, minPre, minCur, ans;
        ans = maxPre = minPre = nums[0];
        // dp1[i] = MAX{dp1[i-1] * nums[i], dp2[i-1] * nums[i], nums[i]}
        // dp2[i] = MIN{dp1[i-1] * nums[i], dp2[i-1] * nums[i], nums[i]}
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            maxCur = Math.max(maxPre * a, Math.max(minPre * a, a));
            minCur = Math.min(minPre * a, Math.min(maxPre * a, a));
            maxPre = maxCur;
            minPre = minCur;
            ans = Math.max(ans, maxCur);
        }
        return ans;
    }
}
