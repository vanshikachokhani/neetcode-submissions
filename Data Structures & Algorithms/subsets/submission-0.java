class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(nums, ans, temp, 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int id){
        if(id>=nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        temp.add(nums[id]);
        backtrack(nums, ans, temp, id+1);
        temp.remove(temp.size()-1);
        backtrack(nums, ans, temp, id+1);
    }
}
