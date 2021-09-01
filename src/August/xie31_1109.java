package August;

import java.util.Arrays;

/**
 * 航班预定统计
 */

public class xie31_1109 {
    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] book : bookings) {
            int tmp = book[2];
            ans[book[0] - 1] += tmp;
            if (book[1] < n) ans[book[1]] -= tmp;
        }
        for (int i = 1; i < n; i++) ans[i] += ans[i - 1];
        return ans;
    }
}
