package LC100Collection.tree;

import xieTest.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从谦虚与中序遍历序列构造二叉树
 */

public class xie105 {
    static int[] pre, in;
    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
     */
    public static void main(String[]  args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7}, inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(xie102.levelOrder(buildTree(preorder, inorder)));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        for (int i = 0; i < in.length; i++) map.put(in[i], i);
        return helper(0, pre.length, 0, in.length);
    }

    static TreeNode helper(int pl, int pr, int il, int ir) {
        if (pl == pr) return null;
        int rootVal = pre[pl];
        int x = map.get(rootVal);
        int lc = x - il;
        return new TreeNode(rootVal,
                helper(pl + 1, pl + lc + 1, il, x),
                helper(pl + lc + 1, pr, x + 1, ir));
    }
}
