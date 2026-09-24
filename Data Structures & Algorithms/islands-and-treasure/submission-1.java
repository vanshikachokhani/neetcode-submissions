class Solution {
    int[] delRow = {-1,0,1,0};
    int[] delCol = {0,-1,0,1};
    int INF = 2147483647;

    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        vis[r][c] = true;
        int steps = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if(grid[row][col]==0) return steps;
                for(int k=0;k<4;k++){
                    int nr = row + delRow[k];
                    int nc = col + delCol[k];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]!=-1){
                        vis[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return INF;
    }

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size()==0) return ;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int k=0;k<4;k++){
                int nr = row + delRow[k];
                int nc = col + delCol[k];
                if(nr>=n || nr<0 || nc>=m || nc<0 || grid[nr][nc]!=INF){ continue;}
                q.add(new int[]{nr,nc});
                grid[nr][nc] = grid[row][col] + 1;
            }
            
        }
    }
}
