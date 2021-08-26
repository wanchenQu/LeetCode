package LC100Collection.MapTest;

public class mapTest {
    public static void main(String[] args) {
        /**
         * 有 n 个网络节点，标记为1到 n。
         * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，
         * 其中ui是源节点，vi是目标节点，wi是一个信号从源节点传递到目标节点的时间。
         * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
         * 1 <= k <= n <= 100
         * 1 <= times.length <= 6000
         * times[i].length == 3
         * 1 <= ui, vi <= n
         * ui != vi
         * 0 <= wi <= 100
         * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
         * */
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
    }

    static int N = 110, M = 6010;

    public static int networkDelayTime(int[][] times, int n, int k) {
        return 1;
    }

    /**
     * 邻接矩阵：w[a][b] = c： 从 a->b存在权重为c的边，适用于边较多的稠密图
     * */
    int[][] w1 = new int[N][N];
    /**
     * 邻接矩阵加边操作
     * */
    void add1(int a, int b, int c) {
        w1[a][b] = c;
    }

    /**
     *  邻接表， 链式向前星存图
     * */
    int idx; // 边的编号
    int[] he = new int[N]; // 从节点he[i]开始的边的链式集合
    int[] ne = new int[M]; // 找到下一条边
    int[] e = new int[M]; // 某一条边指向的节点
    int[] w = new int[M]; // 边的权重
    /**
     * 邻接表加边操作
     * */
    void add(int a, int b, int c) {
        // 当前边是idx
        e[idx] = b; // idx的末端是b
        ne[idx] = he[a]; // 先插入的最后查询
        he[a] = idx;
        w[idx++] = c;
    }
    /**
     * 邻接表遍历方式
     * for (int i = he[x]; i != -1; i = ne[i]) {
     *     int target = e[i];
     *     int cost = w2[i];
     * }
     * */

}