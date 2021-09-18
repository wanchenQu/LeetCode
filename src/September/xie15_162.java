package September;

/**
 * 寻找峰值
 */

public class xie15_162 {
    public static void main(String[] args) {
        /**
         * 峰值元素是指其值严格大于左右相邻值的元素。
         * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
         * 你可以假设nums[-1] = nums[n] = -∞ 。
         * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
         * */
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r >>> 1;
            if (nums[m] < nums[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }
}
