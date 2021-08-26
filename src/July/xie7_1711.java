package July;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐计数
 */
public class xie7_1711 {
    public static void main(String[] args) {
        /**
         * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
         *
         * 你可以搭配 任意 两道餐品做一顿大餐。
         *
         * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，
         * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
         *
         * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
         * */

        int[] deliciousness = new int[]{64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64};
        System.out.println(countPairs(deliciousness));
    }

    public static int countPairs(int[] deliciousness) {
        final int MOD = (int) 1e9 + 7;
        int maxDel = 0;
        for (int del : deliciousness) maxDel = Math.max(maxDel, del);
        maxDel = 2 * maxDel;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int del : deliciousness) {
            for (int i = 1; i <= maxDel; i <<= 1) {
                int c = map.getOrDefault(i - del, 0);
                ans = (ans + c) % MOD;
            }
            map.put(del, map.getOrDefault(del, 0) + 1);
        }
        return ans;
    }
}
