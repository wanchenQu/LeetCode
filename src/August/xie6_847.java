package August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 访问所有节点的最短路径
 */

public class xie6_847 {
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        // 数据量最大12，小于int类型最大二进制长度32 -> 状态压缩二进制表示各个节点的访问状态
        int mask = 1 << n;
        // 表示到达节点，经过状态mask到达节点n消耗的距离
        int[][] dist = new int[mask][n];
        // 初始状态设置全部无穷大
        for (int i = 0; i < mask; i++) Arrays.fill(dist[i], INF);
        Deque<int[]> d = new ArrayDeque<>();
        // 初始状态设置
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            d.addLast(new int[]{1 << i, i});
        }

        // BFS
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int flag = poll[0], curNode = poll[1], curStep = dist[flag][curNode];
            if (flag == mask - 1) return curStep;
            for (int i : graph[curNode]) {
                if (dist[flag | (1 << i)][i] == INF) {
                    dist[flag | (1 << i)][i] = curStep + 1;
                    d.addLast(new int[]{flag | (1 << i), i});
                }
            }
        }
        return -1;
    }


}
