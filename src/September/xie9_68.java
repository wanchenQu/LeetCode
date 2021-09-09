package September;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 */

public class xie9_68 {
    static String[] words;
    static int maxWidth;

    public static void main(String[] args) {
        String[] words = new String[]{
                "Science", "is", "what", "we", "understand", "well",
                "enough", "to", "explain", "to", "a", "computer.",
                "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        for (String i : fullJustify(words, maxWidth)) System.out.println(i);
    }


    public static List<String> fullJustify(String[] _words, int _maxWidth) {
        words = _words;
        maxWidth = _maxWidth;
        /**
         * 一行一词：右边补充空格
         * 最后一行：左对齐，单词之间不插入额外的空格
         * 一行多词：空格尽量均匀分配，左侧比右侧多
         * */
        List<String> ans = new ArrayList<>();
        // 选词
        int count = 0, start = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
            if (count > maxWidth) {
                ans.add(helper(start, i - 1));
                start = i;
                count = words[i].length();
            }
            count++; // 至少一个空格
        }
        ans.add(helper(start, words.length - 1));
        return ans;
    }

    private static String helper(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) onwWordOneRow(start, sb);
        else if (end == words.length - 1) lastRow(start, end, sb);
        else normal(start, end, sb);
        return sb.toString();
    }

    /**
     * 一行一词情况：右边补充空格
     */
    private static void onwWordOneRow(int start, StringBuilder sb) {
        sb.append(words[start]);
        int spaceCount = maxWidth - words[start].length();
        while (spaceCount-- > 0) sb.append(" ");
    }

    /**
     * 最后一行：左对齐，单词之间不插入额外的空格
     */
    private static void lastRow(int start, int end, StringBuilder sb) {
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) sb.append(" ");
            else {
                int spaceCount = maxWidth - sb.length();
                while (spaceCount-- > 0) sb.append(" ");
            }
        }
    }

    /**
     * 一行多词：空格尽量均匀分配，左侧比右侧多
     */
    private static void normal(int start, int end, StringBuilder sb) {
        // 字符长度
        int wordsLen = 0;
        for (int i = start; i <= end; i++) wordsLen += words[i].length();
        // 空格数量
        int spaceCount = maxWidth - wordsLen;
        // 间隙数量
        int gapCount = end - start;
        // 均匀分配数量
        int avg = spaceCount / gapCount;
        // 多余空格
        int left = spaceCount % gapCount;
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                for (int j = 0; j < avg; j++) sb.append(" ");
                if (left-- > 0) sb.append(" ");
            }
        }
    }
}
