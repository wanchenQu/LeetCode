package June;

import java.util.HashMap;
import java.util.Map;

/**
 * 直线上最多的点数
 */
public class xie24_149 {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(solution(points));
        System.out.println(solution2(points));

    }

    private static int solution(int[][] points) {
        int n = points.length;
        int result = 1;
        for (int i = 0; i < n; i++) {
            int[] pI = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] pJ = points[j];
                int temp = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] pK = points[k];
                    if ((pK[1] - pJ[1]) * (pJ[0] - pI[0]) == (pK[0] - pJ[0]) * (pJ[1] - pI[1])) {
                        temp++;
                    }
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    public static int solution2(int[][] points) {
        int n = points.length;
        int result = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int cur = 0;
            for (int j = i + 1; j < n; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int gcd = gcd(a, b);
                String k = (a / gcd) + "|" + (b / gcd);
                map.put(k, map.getOrDefault(k, 0) + 1);
                cur = Math.max(cur, map.get(k));
            }
            result = Math.max(cur+1, result);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
