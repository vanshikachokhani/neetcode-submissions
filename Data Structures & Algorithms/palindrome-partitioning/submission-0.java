class Solution {
    public boolean isPalindrome(String str, int l, int r){
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, res, part, 0);
        return res;
    }

    public void dfs(String s, List<List<String>> res, List<String> part, int id){
        if(id>=s.length()){
            res.add(new ArrayList<>(part));
            return ;
        }
        for(int j=id;j<s.length();j++){
            if(isPalindrome(s,id, j)){
                part.add(s.substring(id,j+1));
                dfs(s, res, part, j+1);
                part.remove(part.size()-1);
            }
        }
    }
}
