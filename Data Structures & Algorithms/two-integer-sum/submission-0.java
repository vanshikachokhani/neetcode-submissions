class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int p = target - nums[i];
            if(mp.containsKey(p)){
                int idx =  mp.get(p);
                if(idx!=i)
                    return new int[]{idx,i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
