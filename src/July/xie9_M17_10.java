package July;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要元素
 */
public class xie9_M17_10 {

    public static void main(String[] args) {
        /**
         * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
         * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
         * */
        int[] nums = new int[]{3, 2, 3};
        System.out.println(solution(nums));

        System.out.println(majorityElement(nums));
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int cnt = map.getOrDefault(i, 0) + 1;
            map.put(i, cnt);
            if (2 * cnt > n) return i;
        }
        return -1;
    }


    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                x = i;
                cnt = 1;
            } else {
                cnt += x == i ? 1 : -1;
            }
        }
        cnt = 0;
        for (int i : nums) {
            if (x == i) cnt++;
        }
        return cnt > n / 2 ? x : -1;
    }
}
