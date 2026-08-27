class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        backtrack(nums, target, ans, temp, 0, n);
        return ans;
    }

    public void backtrack(int[] nums, int target,List<List<Integer>> ans, List<Integer> temp, int id, int n){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i=id;i<n && target>=nums[i];i++){
            if(i==id || nums[i]!=nums[i-1]){
                temp.add(nums[i]);
                backtrack(nums, target-nums[i], ans, temp, i+1, n);
                temp.remove(temp.size()-1); 
            }
        }
    }
}
