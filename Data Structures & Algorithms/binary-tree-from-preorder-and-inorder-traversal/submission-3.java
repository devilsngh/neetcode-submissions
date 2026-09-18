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
    int pre_idx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int iLen = inorder.length;
        for (int i = 0; i < iLen; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, iLen - 1);
    }

    private TreeNode helper(int[] preorder, int l, int r) {
        if (l > r) return null;
        int rootVal = preorder[pre_idx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        root.left = helper(preorder, l, mid - 1);
        root.right = helper(preorder, mid + 1, r);
        return root;
    }
}
