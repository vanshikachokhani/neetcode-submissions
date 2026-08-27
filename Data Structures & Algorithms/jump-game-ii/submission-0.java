class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int l=0,r=0;
        int n = nums.length;
        int longestJump = 0;
        while(r<n-1){
            longestJump = 0;
            for(int i=l;i<=r;i++){
                longestJump = Math.max(longestJump,i+ nums[i]);
            }
            l=r+1;
            r=longestJump;
            ans++;
        }
        return ans;
    }
}
