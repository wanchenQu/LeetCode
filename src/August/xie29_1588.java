package August;

/**
 * 所有奇数长度子数组的和
 */

public class xie29_1588 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 11,12};
        System.out.println(sumOddLengthSubarrays(nums));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, ans = 0;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + arr[i - 1];
        for (int i = 1; i <= n; i += 2) {
            for (int j = i; j <= n; j++) {
                ans += (preSum[j] - preSum[j - i]);
            }
        }
        return ans;
    }
}
