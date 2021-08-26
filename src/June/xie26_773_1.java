package June;

import java.util.*;

public class xie26_773_1 {
    static int N = 2, M = 3;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String l, r;
    static int x, y;

    public static void main(String[] args) {
        int[][] board = new int[][]{{3, 2, 4}, {1, 5, 0}};
        System.out.println(slidingPuzzle(board));
    }


    public static int slidingPuzzle(int[][] board) {
        l = "";
        r = "123450";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                l += board[i][j];
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        if (!check(r)) {
            return -1;
        }
        Node root = new Node(l, x, y, f(l));
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        Map<String, Integer> map = new HashMap<>();
        q.add(root);
        map.put(l, 0);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int step = map.get(poll.str);
            if (poll.str.equals(r)) {
                return step;
            }
            int dx = poll.x, dy = poll.y;
            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                String nStr = update(poll.str, dx, dy, nx, ny);
                if (!map.containsKey(nStr) || map.get(nStr) > step + 1) {
                    Node next = new Node(nStr, nx, ny, step + 1 + f(nStr));
                    q.add(next);
                    map.put(nStr, step + 1);
                }
            }
        }
        return -1;
    }

    // 计算曼哈顿距离总和
    private static int f(String str) {
        int ans = 0;
        char[] cs1 = str.toCharArray(), cs2 = r.toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 跳过空格
                if (cs1[i * M + j] == '0' || cs2[i * M + j] == '0') {
                    continue;
                }
                int cur = cs1[i * M + j], next = cs2[i * M + j];
                int xd = Math.abs((cur - 1) / 3 - (next - 1) / 3);
                int xy = Math.abs((cur - 1) & 3 - (next - 1) % 3);
                ans += (xd + xy);
            }
        }
        return ans;
    }

    /**
     * 而对于通用的 N∗N 数码问题，判定有解的一个充要条件是：「逆序对」数量为偶数，如果不满足，必然无解，直接返回 -1 即可。
     * 对于N*M数码问题，空白在同一行交换不会导致奇偶性互变；上下行交换，如果列为奇数，则不会导致奇偶性互变，如果列数为偶数，则会导致奇偶性互变，所以此时还要考虑上下行交换的次数，综合得出答案。
     */
    // 判断无解情况
    private static boolean check(String str) {
        char[] cs = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '0') {
                list.add(cs[i] - '0');
            }
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    cnt++;
                }
            }
        }
        return cnt % 2 == 0;
    }

    // 实现字符串换位
    private static String update(String cur, int i, int j, int p, int q) {
        char[] cs = cur.toCharArray();
        char tmp = cs[i * M + j];
        cs[i * M + j] = cs[p * M + q];
        cs[p * M + q] = tmp;
        return String.valueOf(cs);
    }

    static class Node {
        // 状态节点，状态字符串+0位置
        String str;
        int x, y;
        // 曼哈顿距离
        int val;

        Node(String str, int x, int y, int val) {
            this.str = str;
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
