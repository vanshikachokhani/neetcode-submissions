class Solution {

    public int[] delRow = {-1,0,1,0};
    public int[] delCol = {0,-1,0,1};

    public void dfs(int[][] heights, int[][] vis, int i, int j, int height){
        int n = heights.length;
        int m = heights[0].length;
        if(i>=n || i<0 || j>=m || j<0 || vis[i][j]==1 || heights[i][j] < height)
            return ;
        
        vis[i][j] = 1;

        for(int k=0;k<4;k++){
            dfs(heights, vis, i+delRow[k], j+delCol[k], heights[i][j]);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for(int i=0;i<n;i++){
            dfs(heights, pacific,i,0, Integer.MIN_VALUE);
            dfs(heights, atlantic,i,m-1,Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){
            dfs(heights, pacific,0,i, Integer.MIN_VALUE);
            dfs(heights, atlantic, n-1,i, Integer.MIN_VALUE);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlantic[i][j]==1 && pacific[i][j] ==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
