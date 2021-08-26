package July;

/**
 * 替换隐藏数字得到的最晚时间
 */
public class xie24_1736 {
    public static void main(String[] args) {
        /**
         * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
         * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
         * 替换time 中隐藏的数字，返回你可以得到的最晚有效时间。
         * */
        String time = "?4:03";
        System.out.println(maximumTime(time));
    }

    public static String maximumTime(String time) {
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        StringBuilder sb = new StringBuilder();
        char tmp = h1 == '?' ? ((h2 != '?' && h2 > '3') ? '1' : '2') : h1;
        sb.append(tmp);
        sb.append(h2 == '?' ? (tmp < '2' ? '9' : '3') : h2);
        sb.append(':');
        sb.append(m1 == '?' ? '5' : m1);
        sb.append(m2 == '?' ? '9' : m2);
        return sb.toString();
    }

}
