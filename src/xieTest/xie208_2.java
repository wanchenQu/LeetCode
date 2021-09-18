package xieTest;

public class xie208_2 {

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

    static class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    static class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) p.tns[u] = new TrieNode();
                p = p.tns[u];
            }
            p.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return p.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) return false;
                p = p.tns[u];
            }
            return true;
        }
    }
}

