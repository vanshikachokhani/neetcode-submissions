class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int curr = nums[0];
        int k = 1;

        for(int i=1;i<n;i++){
            if(nums[i]!=curr){
                nums[k++] = nums[i];
                curr = nums[i];
            }
        }
        return k;
    }
}