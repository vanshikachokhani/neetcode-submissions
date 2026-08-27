class Solution {
    public int helper(int[] nums, int start, int end){
        int n = end-start+1;
        int[] dp =new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start+1], nums[start]);

        for(int i=start+2;i<=end;i++){
            dp[i-start] = Math.max(nums[i]+dp[i-start-2],dp[i-start-1]);
        }
        return dp[n-1];
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int first = helper(nums,0,n-2);
        int second = helper(nums,1,n-1);
        System.out.println(first);
        System.out.println(second);
        return Math.max(first, second);
    }
}
