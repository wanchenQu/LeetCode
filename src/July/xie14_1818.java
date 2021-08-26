package July;

import java.util.Arrays;

/**
 * 绝对差值和
 */
public class xie14_1818 {

    public static void main(String[] args) {
        /**
         * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
         * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
         * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
         * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
         * |x| 定义为：
         * 如果 x >= 0 ，值为 x ，或者
         * 如果 x <= 0 ，值为 -x
         * */
        int[] nums1 = new int[]{1, 10, 4, 4, 2, 7}, nums2 = new int[]{9, 3, 5, 1, 7, 4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int) 1e9 + 7;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (a == b) continue;
            int x = Math.abs(a - b);
            int idx = bs(sorted, nums2[i]);
            ans += x;
            max = Math.max(max, x - Math.abs(nums2[i] - sorted[idx]));
        }
        return (int) ((ans - max) % MOD);
    }

    static int bs(int[] nums, int b) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r + 1 >>> 1;
            if (nums[m] > b) r = m - 1;
            else l = m;
        }
        if (l == nums.length - 1) return l;
        else
            return Math.abs(nums[l] - b) > Math.abs(nums[l + 1] - b) ? l + 1 : l;
    }
}
