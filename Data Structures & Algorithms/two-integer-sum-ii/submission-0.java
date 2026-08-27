class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int[] ans = new int[2];

        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum==target){
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
            if(sum>target)
                right--;
            else
                left++;
        }
        return ans;
    }
}
