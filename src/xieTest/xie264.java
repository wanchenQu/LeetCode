package xieTest;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 丑数2
 */

public class xie264 {
    static int[] nums = new int[]{2, 3, 5};

    public static void main(String[] args) {
        /**
         * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
         * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
         * */
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber2(10));

    }

    public static int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        for (int i = 1; i <= n; i++) {
            long poll = pq.poll();
            if (i == n) return (int) poll;
            for (int num : nums) {
                long tmp = poll * num;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    pq.add(tmp);
                }
            }
        }
        return -1;
    }

    public static int nthUglyNumber2(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n; idx++) {
            int a = ans[i2] * 2, b = ans[i3] * 3, c = ans[i5] * 5;
            int min = Math.min(a, Math.min(b, c));
            if (min == a) i2++;
            if (min == b) i3++;
            if (min == c) i5++;
            ans[idx] = min;
        }
        return ans[n];
    }
}
