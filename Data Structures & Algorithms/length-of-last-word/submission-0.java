class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0; 
        boolean flag = false;
        for(int i=s.length()-1;i>=0;i--){
            if(flag && s.charAt(i)==' '){
                return ans;
            }
            else if(s.charAt(i)!=' '){
                flag = true;
                ans++;
            }
        }
        return ans;
    }
}