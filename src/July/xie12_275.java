package July;

/**
 * H 指数 II
 */
public class xie12_275 {
    public static void main(String[] args) {
        /**
         * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
         * */
        int[] citations = new int[]{0, 1, 3, 5, 6};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l < r) {
            int m = l + r + 1 >>> 1;
            if (check(citations, m)) r = m - 1;
            else l = m;
        }
        return l;
    }

    static boolean check(int[] cs, int m) {
        int temp = 0;
        for (int c : cs) {
            if (c >= m) temp++;
        }
        return temp < m;
    }

}
