package com.qyl.树;

/**
 * @Author: qyl
 * @Date: 2021/3/17 9:20
 * @Description:
 */
public class IsSymmetric {

    /**
     * 判断对称二叉树
     * id: 101
     * level: simple
     * 解法：简单的递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}
