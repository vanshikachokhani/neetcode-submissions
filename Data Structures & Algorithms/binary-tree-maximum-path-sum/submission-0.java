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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return ans;
    }

    public int pathSum(TreeNode root){
        if(root==null)
            return 0;
        
        int leftPathSum = Math.max(0, pathSum(root.left));
        int rightPathSum = Math.max(0, pathSum(root.right));

        ans = Math.max(ans, leftPathSum + rightPathSum + root.val);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}