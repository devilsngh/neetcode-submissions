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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        helper(root, pq);

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }

    private void helper(TreeNode node, PriorityQueue<Integer> pq) {
        if (node == null) return;
        pq.offer(node.val);
        helper(node.left, pq);
        helper(node.right, pq);
    }
}
