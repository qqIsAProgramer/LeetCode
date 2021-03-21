package com.qyl.树;

import javax.swing.*;

/**
 * @Author: qyl
 * @Date: 2021/3/21 9:13
 * @Description:
 */
public class IsValidBST {

    private long pre = Long.MIN_VALUE;

    /**
     * 验证二叉搜索树
     * id: 98
     * level: middle
     * 解法：
     * BST 的中序遍历是升序的
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = inorder(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean r = inorder(root.right);
        return l && r;
    }
}
