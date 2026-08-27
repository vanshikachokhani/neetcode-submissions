class Solution {
    public int[][] generateMatrix(int n) {
        int curr = 1;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int[][] matrix = new int[n][n];

        while(top<=bottom && left<=right){
            for(int i = left;i<=right;i++){
                matrix[top][i] = curr;
                curr++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                matrix[i][right] = curr;
                curr++;
            }
            right--;

            if(!(top<=bottom && left<=right))
                break;

            for(int i=right;i>=left;i--){
                matrix[bottom][i] = curr;
                curr++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                matrix[i][left] = curr;
                curr++;
            }
            left++;
        }
        return matrix;
    }
}