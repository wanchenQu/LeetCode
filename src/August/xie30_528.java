package August;

/**
 * 按权重随机选择
 */
public class xie30_528 {
    int[] sum;

    public xie30_528(int[] w) {
        int n = w.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + w[i - 1];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 3};
        xie30_528 a = new xie30_528(w);
        for (int i = 0; i < 5; i++) System.out.println(a.pickIndex());
    }

    public int pickIndex() {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= t) r = mid;
            else l = mid + 1;
        }
        return r - 1;
    }
}
