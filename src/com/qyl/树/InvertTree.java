package com.qyl.树;

/**
 * @Author: qyl
 * @Date: 2021/3/17 9:32
 * @Description:
 */
public class InvertTree {

    /**
     * 翻转二叉树
     * id: 226
     * level: simple
     * 解法：
     * 先解决最底层的叶子节点，最后自底向上解决
     * 于是想到 ‘树的后续遍历’：左->右->根
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        invert(root.left);
        invert(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
