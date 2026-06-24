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
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        // Traverse Left
        helper(node.left);

        // Process Root
        count--;
        if (count == 0) {
            result = node.val;
            return; // Found the answer
        }

        // Traverse Right (only if we haven't found the answer yet)
        if (count > 0) {
            helper(node.right);
        }
    }
}

