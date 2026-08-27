class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};

    public int dfs(int[][] matrix, int r, int c, int previous, int[][] dp,int n,int m){
        if(r<0 || r>=n || c<0 || c>=m || matrix[r][c]<=previous){
            return 0;
        }

        if(dp[r][c]!=-1) return dp[r][c];

        int ans = 1;
        for(int i=0;i<4;i++){
            int q = dfs(matrix, r+dx[i], c+dy[i], matrix[r][c], dp, n, m);
            ans = Math.max(ans,1 + q);
        }
        dp[r][c] = ans;
        return dp[r][c];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int lip = 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                lip = Math.max(lip, dfs(matrix, i, j, Integer.MIN_VALUE, dp, n, m));
            }
        }
        return lip;
    }
}
