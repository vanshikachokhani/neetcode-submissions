class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int q = Math.abs(nums[i]);
            if(nums[q-1]<0) return q;
            else{
                nums[q-1] = -1*nums[q-1];
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
        return n;
        
    }
}
