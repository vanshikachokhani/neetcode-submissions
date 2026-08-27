class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        backtrack(ans, temp, n, 0, 0);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder temp, int n, int open, int closed){
        if(open == closed && open==n){
            ans.add(temp.toString());
            return ;
        }

        if(open<n){
            temp.append('(');
            backtrack(ans, temp, n, open+1, closed);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closed<open){
            temp.append(')');
            backtrack(ans, temp, n, open, closed+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
