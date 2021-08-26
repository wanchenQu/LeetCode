package June;

import java.util.*;

/**
 * 公交路线
 */
public class xie28_815 {
    /**
     * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
     * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
     * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
     * 求出 【最少乘坐的公交车数量】 。如果不可能到达终点车站，返回 -1 。
     */
    static int s, t;
    static int[][] rs;

    public static void main(String[] args) {
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1, target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        rs = routes;
        s = source;
        t = target;
        if (s == t) {
            return 0;
        }
        return bfs();
    }

    static int bfs() {
        // 从某个车站可以到达的交通车线路
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 经过的交通车线路
        Deque<Integer> dq = new ArrayDeque<>();
        // 进入该路线所经过的站点
        Map<Integer, Integer> m = new HashMap<>();
        // 车辆数量
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                // 从起点可以进入的路线
                if (station == s) {
                    dq.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!dq.isEmpty()) {
            // 从首发站开始做的车
            int poll = dq.pollFirst();
            // 目前做过的车辆数目
            int step = m.get(poll);
            // 该车辆能够到达那些站点
            for (int station : rs[poll]) {
                // 如果当前车辆途径站点包括终点站，返回坐过的车辆数目
                if (station == t) {
                    return step;
                }

                // 本趟车辆无法到达终点站，向下BFS
                Set<Integer> lines = map.get(station);
                // 如果无后续节点，停止向下遍历
                if (lines == null) {
                    continue;
                }
                for (int line : lines) {
                    // 同一路线不多次入队
                    if (!m.containsKey(line)) {
                        dq.addLast(line);
                        m.put(line, step + 1);
                    }
                }
            }
        }
        return -1;
    }
}
