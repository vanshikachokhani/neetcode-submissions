class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, ans, temp, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int start){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = start; i<candidates.length && candidates[i]<=target;i++){
            if(i==start || candidates[i]!=candidates[i-1]){
                temp.add(candidates[i]);
                backtrack(candidates, target-candidates[i], ans, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

}
