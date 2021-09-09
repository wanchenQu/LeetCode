package September;

import java.util.*;

/**
 * IPO
 */

public class xie8_502 {
    public static void main(String[] args) {
        /**
         * 从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最 终可获得的最多资本。
         * */
        int k = 3, w = 0;
        int[] profits = new int[]{3, 1, 2}, capital = new int[]{1, 0, 1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<int[]> list = new ArrayList<>();
        int n = profits.length;
        for (int i = 0; i < n; i++) list.add(new int[]{profits[i], capital[i]});
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            while (cur < n && w >= list.get(cur)[1]) {
                q.add(list.get(cur));
                cur++;
            }
            if (!q.isEmpty()) w += q.poll()[0];
            else break;
        }
        return w;
    }
}
