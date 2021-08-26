package xieTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和3
 */
public class xie437 {
    public static void main(String[] args) {
        /**给定一个二叉树，它的每个结点都存放着一个整数值。
         找出路径和等于给定数值的路径总数。
         路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
         */
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        int target = 8;
        System.out.println(solution(node1, target));
    }

    public static int solution(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return recursion(root, map, target, 0);
    }

    /**
     * 递归函数，计算当前节点下目标和为target的路径数量
     */
    private static int recursion(TreeNode node, Map<Integer, Integer> map, int target, int curPreSum) {
        // 递归终止条件
        if (node == null) {
            return 0;
        }
        curPreSum += node.val;
        //目标节点前缀和为curPreSum - target
        int curResult = map.getOrDefault(curPreSum - target, 0);
        map.put(curPreSum, map.getOrDefault(curPreSum, 0) + 1);
        curResult += recursion(node.left, map, target, curPreSum);
        curResult += recursion(node.right, map, target, curPreSum);
        map.put(curPreSum, map.get(curPreSum) - 1);
        return curResult;
    }
}
