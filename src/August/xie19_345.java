package August;

/**
 * 反转字符串中的元音字母
 */

public class xie19_345 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while (l < r) {
            while (!check(cs[l]) && l < r) l++;
            while (!check(cs[r]) && l < r) r--;
            if (l < r) {
                swap(cs, l, r);
                l++;
                r--;
            }
        }
        return String.valueOf(cs);
    }

    static boolean check(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    static void swap(char[] cs, int l, int r) {
        char tmp = cs[l];
        cs[l] = cs[r];
        cs[r] = tmp;
    }

}
