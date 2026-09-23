class Solution {

    int[] delRow = {-1,0,1,0};
    int[] delCol = {0,-1,0,1};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int r, int c){
        int cnt = 1;
        if(r<0 || r>=grid.length ||c<0 ||c>=grid[0].length || grid[r][c]==0){ 
            return 0;
        }
        grid[r][c] = 0;
        for(int k=0;k<4;k++){
            cnt = cnt + dfs(grid, r + delRow[k], c + delCol[k]);
        }
        return cnt;
    }

}
