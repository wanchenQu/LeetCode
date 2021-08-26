package June;

import xieTest.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 */
public class xie30_O37 {

    public static void main(String[] args) {
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
        String data = serialize(node1);
        System.out.println(data);
        TreeNode ans = deserialize(data);
        System.out.println(serialize(ans));

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return deserializeHelper(dataList);
    }

    private static String serializeHelper(TreeNode root, String ans) {
        if (root == null) {
            ans += "#,";
        } else {
            ans += String.valueOf(root.val) + ",";
            ans = serializeHelper(root.left, ans);
            ans = serializeHelper(root.right, ans);
        }
        return ans;
    }

    private static TreeNode deserializeHelper(List<String> dataList) {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        return root;
    }

}
