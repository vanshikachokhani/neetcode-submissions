class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m-1; //2
        int top = 0;
        int bottom = n-1; // 2
        List<Integer> ans = new ArrayList<>();


        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);  //1,2,3
            }    
            top++;  //1
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]); //6,9
            }
            right--; //1
            if(!(top<=bottom && left<=right)){
                break;
            }
            for(int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);  //8,7
            }
            bottom--; //1
            for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][left]); //4
            }
            left++; //1
        }
        return ans;
    }
}


