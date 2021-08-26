package June;

/**
 * 山脉数组的峰顶索引
 */
public class xie15_853 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 0};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
