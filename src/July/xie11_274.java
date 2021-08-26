package July;

/**
 * H指数
 */
public class xie11_274 {
    public static void main(String[] args) {
        /**
         * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的
         * （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的N - h篇论文每篇被引用次数不超过 h 次。
         * */
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] cs) {
        // 对论文篇数进行二分查找, 猜论文数量（h指数）
        int l = 0, r = cs.length;
        while (l < r) {
            int m = l + r + 1 >>> 1;
            if (check(m, cs)) r = m - 1;
            else l = m;
        }
        return l;
    }

    private static boolean check(int x, int[] cs) {
        int t = 0;
        for (int c : cs) {
            if (c >= x) t++;
        }
        return x > t;
    }
}
