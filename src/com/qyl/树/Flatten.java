package com.qyl.树;

/**
 * @Author: qyl
 * @Date: 2021/3/29 16:45
 */
public class Flatten {

    /**
     * 二叉树展开为列表
     * id: 114
     * level: middle
     * 解法：
     * 后序遍历（这个为什么不会改变树的结构我也没搞懂哇）
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        flatten(root);
        System.out.println(root.val);
    }
}
