class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int[] charSet = new int[256];
        int n = s.length();
        Arrays.fill(charSet,-1);

        for(int right = 0;right<n;right++){
            if(charSet[s.charAt(right)]>=left){
                left = charSet[s.charAt(right)]+1;
            }
            charSet[s.charAt(right)] = right;
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
