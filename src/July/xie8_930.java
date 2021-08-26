package July;

import java.util.HashMap;
import java.util.Map;

/**
 * 和相同的二元子数组
 */
public class xie8_930 {
    public static void main(String[] args) {
        /**
         * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
         *
         * 子数组 是数组的一段连续部分。
         * */
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int ll = 0, lr = 0, r = 0, sl = 0, sr = 0, ans = 0;
        while (r < n) {
            sl += nums[r];
            while (ll <= r && sl > goal) {
                sl -= nums[ll];
                ll++;
            }
            sr += nums[r];
            while (lr <= r && sr >= goal) {
                sr -= nums[lr];
                lr++;
            }
            ans += lr - ll;
            r++;
        }
        return ans;
    }

    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int ps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(ps, map.getOrDefault(ps, 0) + 1);
            ps += num;
            ans += map.getOrDefault(ps - goal, 0);
        }
        return ans;
    }

    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        ps[0] = 0;
        ps[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            ps[i] = ps[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int temp = ps[j] - ps[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return map.getOrDefault(goal, 0);
    }

}
