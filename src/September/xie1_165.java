package September;

/**
 * 比较版本号
 */

public class xie1_165 {

    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int l1 = v1.length, l2 = v2.length, p1 = 0, p2 = 0;
        while (p1 < l1 || p2 < l2) {
            int c1 = 0, c2 = 0;
            if (p1 < l1) c1 = Integer.valueOf(v1[p1++]);
            if (p2 < l2) c2 = Integer.valueOf(v2[p2++]);
            if (c1 != c2) return c1 - c2 > 0 ? 1 : -1;
        }
        return 0;
    }
}
