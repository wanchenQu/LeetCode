package xieTest;

/**
 * 实现Trie前缀树
 */

public class xie208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ape");
        trie.insert("apelsin");
        System.out.println(trie.search("app"));
        trie.insert("apfel");
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


    static class Trie {
        int N = 100009;
        int[][] trie;
        int[] count;
        int index;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            trie = new int[N][26]; // 存储所有的单词字符
            count = new int[N]; // 某个格子被标记为结尾的次数
            index = 0; // 已经用了多少个格子
        }

        /**1
         * Inserts a word into the trie.
         */
        public void insert(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) trie[p][u] = ++index;
                p = trie[p][u];
            }
            count[p]++;
        }

        /**1
         * Returns if the word is in the trie.
         */
        public boolean search(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }
    }
}
