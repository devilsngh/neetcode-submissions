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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[2];
        count[0] = k;
        helper(root, count);
        return count[1];
    }

    private void helper(TreeNode node, int[] count) {
        if (node == null) return;
        helper(node.left, count);
        if (count[0] == 0) return;
        count[0] -= 1;
        if (count[0] == 0) {
            count[1] = node.val;
            return;
        }
        helper(node.right, count);
    }
}
