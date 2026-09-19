/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public void helper(TreeNode node) {
        if (node == null ) return;
        int left = getMax(node.left);
        int right = getMax(node.right);

        maxSum = Math.max(maxSum, left + right + node.val);

        helper(node.left);
        helper(node.right);
    }

    private int getMax(TreeNode node) {
        if (node == null) return 0;
        int left = getMax(node.left);
        int right = getMax(node.right);
        int path = node.val + Math.max(left, right);
        return Math.max(0, path);
    }
}
