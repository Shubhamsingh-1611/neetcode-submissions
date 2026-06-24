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
    public boolean isSame2Tree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSame2Tree(p.left, q.left) && isSame2Tree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If the main tree is empty, subRoot cannot be a subtree
        if (root == null) return false;
        
        // 1. Check if the trees are identical starting from the current node
        if (isSame2Tree(root, subRoot)) return true;
        
        // 2. If not identical, recursively look into the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
