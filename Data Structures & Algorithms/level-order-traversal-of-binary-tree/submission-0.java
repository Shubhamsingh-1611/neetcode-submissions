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
     public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge Case: Handle empty tree safely
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            // Step 1: Capture the exact number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            
            // Step 2: Loop exactly levelSize times to process only this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevelList.add(curr.val);
                
                // Queue up children for the next level
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            
            // Step 3: Add the finished level to your main result list
            result.add(currentLevelList);
        }
        
        return result;
    }
}
