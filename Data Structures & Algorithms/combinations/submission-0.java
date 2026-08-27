class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();

       backtrack(n, k, ans, temp, 1);

       return ans;
    }

    public void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> temp, int start){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i=start;i<=n;i++){
            temp.add(i);
            backtrack(n,k,ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}