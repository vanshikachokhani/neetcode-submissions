class Solution {
    public int maxProduct(int[] nums) {
        int maxi = nums[0];
        int currMin = 1, currMax = 1;
        int n = nums.length;

        for(int i=0;i<n;i++){
            int temp = currMax;

            currMax = Math.max(nums[i], Math.max(nums[i]*currMin, nums[i]*currMax));
            currMin = Math.min(nums[i], Math.min(nums[i]*currMin, nums[i]*temp));

            maxi = Math.max(maxi, currMax);
        }
        return maxi;
    }
}
// -1 -2 -3 -4 -5
// 1 2 -3 4 3 -1