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
    int[] max = new int[1];
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return max[0];
        helper(root);
        return max[0];
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
}
