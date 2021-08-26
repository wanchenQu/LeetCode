package August;

/**
 * 唤醒数组是否存在循环
 */

public class xie7_457_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int[] vis = new int[n];
        for (int i = 0, vi = 1; i < n; i++, vi++) {
            if (vis[i] != 0) continue;
            boolean flag = nums[i] > 0;
            int cur = i;
            while (true) {
                int next = ((cur + nums[cur]) % n + n) % n;
                if (next == cur) break;
                if (vis[next] != 0) {
                    if (vis[next] == vi) return true;
                    else break;
                }
                if (flag && nums[next] < 0) break;
                if (!flag && nums[next] > 0) break;
                cur = next;
                vis[cur] = vi;
            }
        }
        return false;
    }
}
