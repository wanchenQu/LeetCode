package August;

import java.util.*;

/**
 * 找到最终的安全状态
 * 拓扑排序
 */

public class xie5_802_2 {
    static int N = 10010, M = 4 * N, idx;
    static int[] he = new int[N], ne = new int[M], e = new int[M],

    /**
     * 反向入度统计
     */
    cnts = new int[N];

    public static void main(String[] args) {
        int[][] graph = new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        /** 建反向图 */
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                add(j, i);
                cnts[i]++;
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) dq.addLast(i);
        }
        while (!dq.isEmpty()) {
            int poll = dq.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--cnts[j] == 0) dq.addLast(j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (cnts[i] == 0) ans.add(i);
        }
        return ans;
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
}

