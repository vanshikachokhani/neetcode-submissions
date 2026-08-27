class Solution {

    public int[] delRow = {1,0,-1,0};
    public int[] delCol = {0,1,0,-1};

    public int numIslands(char[][] grid) {
        int count  = 0;
        int n = grid.length;
        int m = grid[0].length;

        if(n==0) return count;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 ||j>=m || grid[i][j]!='1')
            return ;
        grid[i][j] = '0';
        for(int k=0;k<4;k++){
            dfs(grid, i+delRow[k], j+delCol[k], n, m);
        }
    }
}
