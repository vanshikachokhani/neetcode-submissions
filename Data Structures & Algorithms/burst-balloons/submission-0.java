class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n+2];
        ballons[0] = ballons[n+1] = 1;
        for(int i=0;i<n;i++){
            ballons[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return dfs(ballons, 1, n,dp);
    }

    // public int dfs(int[] ballons){
    //     if(ballons.length==2) return 0;

    //     int maxCoins = 0;
    //     for(int i=1;i<ballons.length-1;i++){
    //         int coins = ballons[i] * ballons[i-1] * ballons[i+1];
    //         int[] newBallons = new int[ballons.length-1];
    //         for(int j=0,k=0;j<ballons.length;j++){
    //             if(i!=j)newBallons[k++] = ballons[j];
    //         }
    //         coins+=dfs(newBallons);
    //         maxCoins = Math.max(coins, maxCoins);
    //     }
    //     return maxCoins;
    // }


    public int dfs(int[] nums, int l, int r, int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];

        dp[l][r] = 0;

        for(int i = l; i<=r;i++){
            int coins = nums[l-1]*nums[i]*nums[r+1];
            coins = coins + dfs(nums, l,i-1,dp) + dfs(nums,i+1,r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}

