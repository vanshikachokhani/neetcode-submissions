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
    int q;
    int count = 0;
    TreeNode ans;

    public void inorder(TreeNode node){
        if(node == null)
            return ;
        inorder(node.left);
        count++;
        if(count==q){
            ans = node;
            return ;
        }
        inorder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        q = k;
        inorder(root);
        return ans.val;
    }
}
