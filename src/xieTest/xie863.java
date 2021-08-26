package xieTest;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 二叉树中所有距离为 K 的结点
 */
public class xie863 {

    static int N = 510, M = 4 * N, idx;
    static int[] he = new int[N], ne = new int[M], e = new int[M];
    static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        /**
         * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
         * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
         * */
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))
                ),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );
        System.out.println(distanceK(root, root.left, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(he, -1);
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(target.val);
        vis[target.val] = true;

        while (!q.isEmpty() && k >= 0) {
            int size = q.size();
            while (size-- > 0) {
                int poll = q.pollFirst();
                if (k == 0) {
                    ans.add(poll);
                    continue;
                }
                for (int i = he[poll]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (!vis[j]) {
                        q.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }

    static void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
}


