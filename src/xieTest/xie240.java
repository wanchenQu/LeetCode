package xieTest;

/**
 * 搜索二维矩阵2
 */
public class xie240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 8;
        int[] test = new int[]{1, 1, 2, 3, 5, 8, 13, 21};
        System.out.println(findFX(test, target));
    }

    public static int findFX(int[] test, int target) {
        int l = 0;
        int r = test.length - 1;
        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if (test[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return test[l];
    }

}
