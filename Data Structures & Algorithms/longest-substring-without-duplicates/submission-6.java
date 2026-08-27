class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        int[] charSet = new int[256];
        int maxLen = 1;
        int left = 0;
        Arrays.fill(charSet,-1);
        for(int i=0;i<n;i++){
            if(charSet[s.charAt(i)]>=left){
                left = charSet[s.charAt(i)]+1;
            }
            
            charSet[s.charAt(i)] = i;
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }
}
