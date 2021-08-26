package xieTest;
/**
 * 单词接龙
 */

import java.util.*;

/**
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典wordList 中的单词。
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，找到从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 */
public class xie127 {

    static String l, r;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<String>(list.length);
        Collections.addAll(wordList, list);
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String _l, String _r, List<String> ws) {
        l = _l;
        r = _r;
        for (String w :
                ws) {
            set.add(w);
        }
        if (!set.contains(_r)) {
            return 0;
        }
        int result = bfs();
        return result == -1 ? 0 : result + 1;
    }

    private static int bfs() {
        Deque<String> l2rq = new ArrayDeque<>(), r2lq = new ArrayDeque<>();
        Map<String, Integer> lcMap = new HashMap<>(), rcMap = new HashMap<>();
        l2rq.add(l);
        r2lq.add(r);
        lcMap.put(l, 0);
        rcMap.put(r, 0);

        while (!l2rq.isEmpty() && !r2lq.isEmpty()) {
            int t = -1;
            if (l2rq.size() <= r2lq.size()) {
                t = update(l2rq, lcMap, rcMap);
            } else {
                t = update(r2lq, rcMap, lcMap);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private static int update(Deque<String> Q, Map<String, Integer> I, Map<String, Integer> U) {
        String poll = Q.pollFirst();
        int n = poll.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                // temp表示当前替换后单词
                String temp = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                if (set.contains(temp)) {
                    if (I.containsKey(temp)) {
                        continue;
                    }
                    if (U.containsKey(temp)) {
                        return I.get(poll) + U.get(temp) + 1;
                    } else {
                        Q.add(temp);
                        I.put(temp, I.get(poll) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
