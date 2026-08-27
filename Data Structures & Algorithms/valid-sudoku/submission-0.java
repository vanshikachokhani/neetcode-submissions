class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> st = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] =='.') continue;
                if(st.contains(board[i][j]))
                    return false;
                st.add(board[i][j]);
            }
        }

        for(int j=0;j<9;j++){
            Set<Character> st = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j] =='.') continue;
                if(st.contains(board[i][j]))
                    return false;
                st.add(board[i][j]);
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Set<Character> st = new HashSet<>();
                for(int row = 0;row<3;row++){
                    for(int col=0;col<3;col++){
                        if(board[3*i + row][3*j+col] =='.') continue;
                        if(st.contains(board[3*i + row][3*j+col]))
                            return false;
                        st.add(board[3*i + row][3*j+col]);
                    }
                }
            }
        }

        return true;
    }
}
