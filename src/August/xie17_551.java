package August;

/**
 * 学生出勤记录1
 */

public class xie17_551 {
    public static void main(String[] args) {
        /**
         * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
         *
         * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
         * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
         * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
         * */
        String s = "AAAA";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        int n = s.length();
        if (n == 1) return true;
        if (n == 2) return s.charAt(0) != 'A' || s.charAt(1) != 'A';
        int cnt = 0;
        if (s.charAt(0) == 'A') cnt++;
        if (s.charAt(1) == 'A') cnt++;
        for (int l = 0, m = 1, r = 2; r < n; l++, m++, r++) {
            if (s.charAt(r) == 'A') cnt++;
            if (cnt >= 2) return false;
            if (s.charAt(l) == 'L' && s.charAt(m) == 'L' && s.charAt(r) == 'L') return false;
        }
        return true;
    }
}
