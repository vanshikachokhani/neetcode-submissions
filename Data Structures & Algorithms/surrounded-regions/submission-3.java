class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};

    public void dfs(int x, int y,int[][] vis,char[][] board, int n, int m){
        if(x>=0 && y>=0 && x<n && y<m && board[x][y]=='O' && vis[x][y]!=1){
           vis[x][y] = 1;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && vis[nx][ny]!=1)
                    dfs(nx,ny,vis, board,n,m);
            } 
            return ;
        }
        return ;
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int i=0;i<m;i++){
            dfs(0,i,vis,board,n,m);
            dfs(n-1,i, vis, board, n, m);
        }
        for(int i=0;i<n;i++){
            dfs(i,0,vis,board,n,m);
            dfs(i,m-1,vis,board,n,m);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        return ;
    }
}
