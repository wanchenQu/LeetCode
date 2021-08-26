package July;

/**
 * 在排序数组中查找数字I
 */
public class xie16_O53_1 {
    public static void main(String[] args) {
        /**统计一个数字在排序数组中出现的次数*/
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int l = findL(nums, target);
        if (l != -1) return findR(nums, target) - l + 1;
        else return 0;
    }

    static int findL(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r >>> 1;
            if (nums[m] < t) l = m + 1;
            else r = m;
        }
        return nums[l] == t ? l : -1;
    }

    static int findR(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + r + 1 >>> 1;
            if (nums[m] > t) r = m - 1;
            else l = m;
        }
        return nums[l] == t ? l : -1;
    }
}
