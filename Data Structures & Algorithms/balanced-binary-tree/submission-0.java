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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int lh = helper(root.left);
        int rh = helper(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int lh = helper(node.left);
        int rh = helper(node.right);

        return 1 + Math.max(lh, rh);
    }
}
