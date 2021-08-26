package July;

import java.util.Arrays;

/**
 * 最高频元素的频数
 */
public class xie19_1838 {
    public static void main(String[] args) {
        /**
         * 元素的 频数 是该元素在一个数组中出现的次数。
         *
         * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
         *
         * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
         * */
        int[] nums = new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
        int k = 3056;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int[] ps = new int[n];
        ps[0] = nums[0];
        for (int i = 1; i < n; i++) ps[i] = ps[i - 1] + nums[i];
        for (int i = 0; i < n; i++) {
            int l = 0, r = i, res = -1;
            while (l <= r) {
                int m = l + r >>> 1;
                if (nums[i] * (i - m + 1) - ps[i] + (m > 0 ? ps[m - 1] : 0) <= k) {
                    r = m - 1;
                    res = m;
                } else l = m + 1;
            }
            if (res != -1) ans = Math.max(ans, i - l + 1);
//            while (l < r) {
//                int m = l + r + 1 >>> 1;
//                int s = nums[i] * (i - m + 1) - ps[i] + ps[m - 1];
//                if (nums[i] * (i - m + 1) - ps[i] + ps[m - 1] <= k) r = m - 1;
//                else l = m;
//            }
//            if (nums[i] * (i - l + 1) - ps[i] + (l > 0 ? ps[l - 1] : 0) <= k) {
//                ans = Math.max(ans, i - l + 1);
//            }
        }
        return ans;
    }
}
