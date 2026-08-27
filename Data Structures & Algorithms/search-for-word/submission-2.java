class Solution {

    public int[] delRow = {-1,0,1,0};
    public int[] delCol = {0,-1,0,1};

    public boolean search(String word, char[][] board, int row, int col, int id, int n, int m){
        if(id==word.length())
            return true;
        
        if(row<0 || col<0 || row>=n || col>=m)
            return false;
        if(board[row][col]=='*') return false;
        if(board[row][col] == word.charAt(id)){
            char c = word.charAt(id);
            board[row][col]='*';
            for(int i=0;i<4;i++){
                if(search(word, board,row+delRow[i], col + delCol[i], id+1, n,m))
                    return true;
            }
            board[row][col] = c;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(search(word, board, i, j, 0, n,m))
                    return true;
            }
        }
        return false;
    }
}
