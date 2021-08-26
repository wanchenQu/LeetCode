package August;

/**
 * 逃脱阻碍者
 */

public class xie22_789 {
    public static void main(String[] args) {
        int[][] ghosts = new int[][]{{1, 0}, {0, 3}};
        int[] target = new int[]{0, 1};
        System.out.println(escapeGhosts(ghosts, target));
    }

    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min = dist(new int[]{0, 0}, target);
        for (int[] g : ghosts) {
            if (dist(target, g) <= min) return false;
        }
        return true;
    }

    static int dist(int[] p1, int[] p2) {
        return Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);
    }
}
