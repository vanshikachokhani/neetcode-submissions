class Solution {
   int[] dx = {-1,0,1,0};
   int[] dy = {0,-1,0,1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int time = 0;

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        
        while(q.isEmpty()==false && fresh>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int j=0;j<4;j++){
                    int x = curr[0] + dx[j];
                    int y = curr[1] + dy[j];
                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1){
                        fresh--;
                        grid[x][y]=2;
                        q.offer(new int[]{x,y});
                    }
                }
            }
            time++; 
        }

        return fresh>0 ? -1 : time;
    }
}
