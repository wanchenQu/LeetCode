package September;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 */

public class xie14_524 {
    public static void main(String[] args) {
        /**
         * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
         * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
         * */
        String[] dic = new String[]{"ale", "apple", "monkey", "plea"};
        String s = "abpcplea";
        System.out.println(findLongestWord(s, Arrays.asList(dic)));

    }

    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });
        int l1 = s.length();
        for (String w : dictionary) {
            int p1 = 0, p2 = 0, l2 = w.length();
            while (p1 < l1 && p2 < l2) {
                while (p1 < l1 && s.charAt(p1) != w.charAt(p2)) p1++;
                if (p1 < l1 && p2 < l2 && s.charAt(p1) == w.charAt(p2)) {
                    p1++;
                    p2++;
                }
            }
            if (p2 == l2) return w;
        }
        return "";
    }
}
