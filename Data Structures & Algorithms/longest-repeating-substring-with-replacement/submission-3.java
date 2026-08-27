class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int mostFreq = 0;
        int left = 0;
        int maxLen = 0;

        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(right)-'A']);
            int letter = right-left + 1 - mostFreq;
            if(letter>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            System.out.println(maxLen);
        }
        return maxLen;
    }
}

//ABAA
// 1 1 
