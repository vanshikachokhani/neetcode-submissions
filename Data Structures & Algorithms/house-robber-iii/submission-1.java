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

    HashMap<TreeNode,Integer> mp;
    
    public int dfs(TreeNode root){
        if(mp.containsKey(root)){
            return mp.get(root);
        }
        
        int res = root.val;

        if(root.left!=null){
            res+=dfs(root.left.left) + dfs(root.left.right);
        }

        if(root.right!=null){
            res+=dfs(root.right.left) + dfs(root.right.right);
        }

        res = Math.max(res, dfs(root.left)+dfs(root.right));
        mp.put(root,res);
        return res;
    }

    public int rob(TreeNode root) {
        mp = new HashMap<>();
        mp.put(null,0);
        return dfs(root);
    }
}