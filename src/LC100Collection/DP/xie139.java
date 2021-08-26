package LC100Collection.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 */

public class xie139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // dp[i] = forEach(w in wordDict) dp[i-w.length] && dp[i-w.len ~ i] == w
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String cur = wordDict.get(j);
                int k = cur.length();
                if (i >= k && dp[i - k] && s.substring(i - k, i).equals(cur)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
