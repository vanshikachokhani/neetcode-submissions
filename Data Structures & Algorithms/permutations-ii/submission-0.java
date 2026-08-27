class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num:nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        List<Integer> temp = new ArrayList<>();

        backtrack(nums, ans, temp, mp);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, Map<Integer, Integer> mp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int num : mp.keySet()){
            if(mp.get(num)>0){
                temp.add(num);
                mp.put(num, mp.get(num)-1);
                backtrack(nums, ans, temp, mp);
                mp.put(num, mp.get(num)+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}