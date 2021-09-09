package September;

/**
 * 二分查找
 */

public class xie6_704 {
    public static void main(String[] args) {
        /**
         * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
         * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
         * */
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r + 1 >>> 1;
            if (nums[m] > target) r = m - 1;
            else l = m;
        }
        return nums[l] == target ? l : -1;
    }
}
