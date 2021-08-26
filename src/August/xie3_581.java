package August;

/**
 * 最短无序连续子数组
 */

public class xie3_581 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 2};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[l] <= nums[l + 1]) l++;
        if (l == n - 1) return 0;
        while (l < r && nums[r] >= nums[r - 1]) r--;
        int t1 = Math.max(nums[l], nums[r]), t2 = Math.min(nums[l], nums[r]);
        for (int i = l + 1; i < r; i++) {
            t1 = Math.max(t1, nums[i]);
            t2 = Math.min(t2, nums[i]);
        }
        int i1 = 0, j1 = l;
        while (i1 < j1) {
            int m1 = i1 + j1 >>> 1;
            if (nums[m1] <= t2) i1 = m1 + 1;
            else j1 = m1;
        }
        int i2 = r, j2 = n - 1;
        while (i2 < j2) {
            int m2 = i2 + j2 + 1 >>> 1;
            if (nums[m2] >= t1) j2 = m2 - 1;
            else i2 = m2;
        }
        return i2 == i1 ? 0 : i2 - i1 + 1;
    }
}
