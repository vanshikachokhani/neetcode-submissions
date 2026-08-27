class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxLen = 0;
        int mostFreqLetter = 0;
        int left = 0;

        for(int right = 0; right<n ; right++){
            freq[s.charAt(right)-'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right)-'A']);
            int letterToChange = right - left + 1 - mostFreqLetter;
            if(letterToChange>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
