class Solution {

    private boolean[][] vis;
    private int[] delRow = {-1,0,1,0};
    private int[] delCol = {0,-1,0,1};
    int n;
    int m;

    public int islandPerimeter(int[][] grid) {
         n = grid.length;
         m = grid[0].length;
        vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return dfs(i,j, grid);
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int[][] grid){
        if(i<0 || i>n-1 || j<0 || j>m-1 || grid[i][j]==0){
            return 1;
        }
        if(vis[i][j]){
            return 0;
        }
        vis[i][j] = true;

        int res = 0;
        for(int k=0;k<4;k++){
            res = res + dfs(i+delRow[k], j+delCol[k], grid);
        }
        return res;
    }
}