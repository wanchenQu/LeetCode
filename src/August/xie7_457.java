package August;

/**
 * 环形数组是否存在循环
 */

public class xie7_457 {
    static int[] nums;
    static int n;

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-1,-2,-2};
        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] _nums) {
        nums = _nums;
        n = nums.length;
        /**
         * next = cur + nums[cur]
         * next可能大于n next = next % n
         * next可能小于0 next = n + next
         * next = ((cur + nums[cur]) % n + n) %n;
         */
        for (int i = 0; i < n; i++) {
            if (check(i)) return true;
        }
        return false;
    }

    public static boolean check(int start) {
        int cur = start;
        boolean flag = nums[start] > 0;
        int k = 1;
        while (true) {
            if (k > n) return false;
            int next = ((cur + nums[cur]) % n + n) % n;
            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            cur = next;
            k++;
        }
    }
}
