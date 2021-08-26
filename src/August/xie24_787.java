package August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * K 站中转内最便宜的航班
 */

public class xie24_787 {
    static int N = 110, M = 6600, idx;
    static int[] he = new int[N], ne = new int[M], e = new int[M], w = new int[M];

    public static void main(String[] args) {
        int n = 3, src = 0, dst = 2, k = 0;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice(n, edges, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;
        Arrays.fill(he, -1);
        for (int[] f : flights) add(f[0], f[1], f[2]);
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{src, 0, prices[src]});
        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            if (poll[1] > k) break;
            for (int i = he[poll[0]]; i != -1; i = ne[i]) {
                int j = e[i];
                if (prices[j] > poll[2] + w[i]) {
                    prices[j] = poll[2] + w[i];
                    q.addLast(new int[]{j, poll[1] + 1, prices[j]});
                }
            }
        }
        return prices[dst] == INF ? -1 : prices[dst];
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        w[idx] = c;
        he[a] = idx++;
    }
}
