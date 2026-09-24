class Solution {
    int[] delRow = {-1,0,1,0};
    int[] delCol = {0,-1,0,1};

    public int swimInWater(int[][] grid) {
        int mini = grid[0][0];
        int maxi = grid[0][0];

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mini = Math.min(mini, grid[i][j]);
                maxi = Math.max(maxi, grid[i][j]);
            }
        }

        int[][] vis = new int[n][m];
        for(int k=0;k<n;k++){
            Arrays.fill(vis[k], 0);
        }

        int l = mini;
        int r = maxi;
        while(l<r){
            int mid = (l+r)/2;
            if(dfs(grid, vis, mid, 0,0)){
                r = mid;
            }
            else{
                l = mid+1;
            }
            for(int k=0;k<n;k++){
                Arrays.fill(vis[k], 0);
            }
        }
        return r;
    }

    public boolean dfs(int[][] grid, int[][] vis, int t, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || vis[r][c]==1 || grid[r][c] > t){
            return false;
        }
        if(r==grid.length-1 && c==grid[0].length-1) return true;
        vis[r][c] = 1;
        return dfs(grid, vis, t, r+1,c) || 
        dfs(grid, vis, t, r-1,c) ||
        dfs(grid, vis, t, r,c+1) ||
        dfs(grid, vis, t, r,c-1);
    }
}
