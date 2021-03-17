package com.qyl.动态规划.打家劫舍;

/**
 * @Author: qyl
 * @Date: 2021/3/17 21:15
 * @Description:
 */
public class Rob3 {

    /**
     * 打家劫舍III（树型 dp）
     * id: 337
     * level: middle
     * 解法：
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     *
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为 2 的数组来表示 int[] dp = new int[2] (0 代表不偷，1 代表偷)
     *
     * 任何一个节点能偷到的最大钱的状态可以定义为：
     *
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
     * dp[1] = left[0] + right[0] + root.val;
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] dp = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;

        return dp;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
