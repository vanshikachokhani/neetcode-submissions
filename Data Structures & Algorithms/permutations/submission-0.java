class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int n = nums.length;
        boolean[] vis = new boolean[n];


        backtrack(nums, temp, ans, n, vis);
        return ans;
    }

    public void backtrack(int[] nums,List<Integer> temp, List<List<Integer>> ans, int n, boolean[] vis){
        if(temp.size()==n){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                vis[i]=true;
                temp.add(nums[i]);
                backtrack(nums, temp, ans, n , vis);
                vis[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
