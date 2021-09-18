package September;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索2
 */

public class xie16_212 {
    static TrieNode root = new TrieNode();
    static Set<String> set = new HashSet<>();
    static char[][] board;
    static int m, n;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] vis = new boolean[15][15];

    public static void main(String[] args) {
        /**
         * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
         * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
         * 同一个单元格内的字母在一个单词中不允许被重复使用。
         * */
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] _board, String[] words) {
        board = _board;
        m = board.length;
        n = board[0].length;
        for (String s : words) insert(s);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = board[i][j] - 'a';
                if (root.tns[u] != null) {
                    vis[i][j] = true;
                    dfs(i, j, root.tns[u]);
                    vis[i][j] = false;
                }
            }
        }
        return new ArrayList<>(set);
    }

    static void dfs(int i, int j, TrieNode node) {
        if (node.s != null) set.add(node.s);
        for (int[] dir : dirs) {
            int dx = i + dir[0], dy = j + dir[1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
            if (vis[dx][dy]) continue;
            int u = board[dx][dy] - 'a';
            if (node.tns[u] != null) {
                vis[dx][dy] = true;
                dfs(dx, dy, node.tns[u]);
                vis[dx][dy] = false;
            }
        }
    }

    static void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.s = s;
    }

    static class TrieNode {
        String s;
        TrieNode[] tns = new TrieNode[26];
    }
}
