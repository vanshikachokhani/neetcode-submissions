class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        
        String str1 = "";
        for(int i=0;i<n;i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                str1 = str1 + s.charAt(i);
        }
        String str = str1.toLowerCase();
        int left = 0;
        int right = str.length()-1;
        while(left<=right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
