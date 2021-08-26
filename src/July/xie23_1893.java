package July;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 检查是否区域内所有整数都被覆盖
 */
public class xie23_1893 {
    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1, 3}, {1, 2}, {4, 6}, {9, 10}};
        int left = 1, right = 5;
        //System.out.println(isCovered1(ranges, left, right));
        System.out.println(isCovered2(ranges, left, right));
        System.out.println(isCovered3(ranges, left, right));

    }

    public static boolean isCovered1(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        for (int[] range : ranges) {
            int l = range[0], r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }
        return left > right;
    }

    public static boolean isCovered2(int[][] ranges, int left, int right) {
        boolean[] res = new boolean[51];
        for (int[] range : ranges) {
            for (int i = Math.max(left, range[0]); i <= Math.min(right, range[1]); i++) {
                res[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (res[i] == false) return false;
        }
        return true;
    }

    public static boolean isCovered3(int[][] ranges, int left, int right) {
        int[] ans = new int[52];
        for (int[] range : ranges) {
            ans[range[0]]++;
            ans[range[1] + 1]--;
        }
        for (int i = 1; i < 52; i++) {
            ans[i] += ans[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (ans[i] <= 0) return false;
        }
        return true;
    }

}
