package September;

/**
 * 找到需要补充粉笔的学生编号
 */

public class xie10_1894 {
    public static void main(String[] args) {
        int[] chalk = new int[]{5, 1, 5};
        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n];
        preSum[0] = chalk[0];
        for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + chalk[i];
        int l = 0, r = n - 1, target = (int) (k % preSum[n - 1]);
        while (l < r) {
            int m = l + r >>> 1;
            if (preSum[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
