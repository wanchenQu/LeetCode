package June;

import java.util.*;

/**
 * 滑动谜题
 */
public class xie26_773 {
    /**
     * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用0来表示.
     * 一次移动定义为选择0与一个相邻的数字（上下左右）进行交换.
     * 最终当板board的结果是[[1,2,3],[4,5,0]]谜板被解开。
     * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
     * 示例：
     * 输入：board = [[1,2,3],[4,0,5]]
     * 输出：1
     * 解释：交换 0 和 5 ，1 步完成
     */
    static int N = 2, M = 3;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String l, r;
    static int x, y;

    public static void main(String[] args) {
        int[][] board = new int[][]{{3, 2, 4}, {1, 5, 0}};
        System.out.println(slidingPuzzle1(board));
    }

    public static int slidingPuzzle1(int[][] board) {
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
        int ans = bfs();
        return ans;
    }

    private static int bfs() {
        Deque<Node> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        Node root = new Node(l, x, y);
        q.addLast(root);
        map.put(l, 0);
        while (!q.isEmpty()) {
            Node poll = q.pollFirst();
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
                if (map.containsKey(nStr)) {
                    continue;
                }
                Node next = new Node(nStr, nx, ny);
                q.addLast(next);
                map.put(nStr, step + 1);
            }
        }
        return -1;
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

        Node(String str, int x, int y) {
            this.str = str;
            this.x = x;
            this.y = y;
        }
    }

}