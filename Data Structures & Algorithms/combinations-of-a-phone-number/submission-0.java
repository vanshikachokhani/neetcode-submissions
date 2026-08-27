class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        backtrack(digits, ans, 0, "");
        return ans;
    }

    private void backtrack(String digits, List<String> ans, int id, String temp){
       if(temp.length()==digits.length()){
            ans.add(temp);
            return ;
       }

       String chars  = digitToChar[digits.charAt(id)-'0'];
        for(char c: chars.toCharArray()){
            backtrack(digits, ans, id+1, temp+c);
        }
    }
}
