package July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 得到子序列的最少操作次数
 */
public class xie26_1713 {
    public static void main(String[] args) {
        /***
         * 给你一个数组target，包含若干 互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。
         * 每一次操作中，你可以在 arr的任意位置插入任一整数。  * 请你返回 最少操作次数，使得target成为arr的一个子序列。
         */
        int[] target = new int[]{1, 3, 8};
        int[] arr = new int[]{2, 6};
        System.out.println(minOperations(target, arr));
    }

    public static int minOperations(int[] target, int[] arr) {
        int m = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) map.put(target[i], i);
        List<Integer> arrIdx = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) arrIdx.add(map.get(j));
        }

        // 寻找arrIdx的最长递增子序列
        int len = arrIdx.size();
        if (len == 0) return m;
        int[] ans = new int[len];
        int p = 0;
        ans[p] = arrIdx.get(p);
        for (int i = 1; i < len; i++) {
            int cur = arrIdx.get(i);
            if (cur > ans[p]) ans[++p] = cur;
            else {
                int l = 0, r = p;
                while (l < r) {
                    int mid = l + r >>> 1;
                    if (ans[mid] < cur) l = mid + 1;
                    else r = mid;
                }
                ans[l] = cur;
            }
        }
        return m - p - 1;
    }
}
