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
    int max = Integer.MIN_VALUE;
       public int solve(TreeNode root) {
        if(root==null) return 0;

        int lh = solve(root.left);
        int rh = solve(root.right);

        int dono_acha  = root.val+lh+rh;

        int ek_acha = root.val+Math.max(lh,rh);

        int koi_nahi = root.val;

        max = Math.max(max,Math.max(dono_acha,Math.max(ek_acha,koi_nahi)));

        return Math.max(ek_acha,koi_nahi);


    }
  
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;

    }
}
