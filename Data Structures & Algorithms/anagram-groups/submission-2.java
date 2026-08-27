class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            String st = strs[i];
            int[] freq = new int[26];

            for(int j=0;j<st.length();j++){
                freq[st.charAt(j)-'a']++;
            }

            String freqStr = Arrays.toString(freq);
            mp.putIfAbsent(freqStr, new ArrayList<>());
            mp.get(freqStr).add(strs[i]);
            // Arrays.sort(charArray);
            // String sortedSt = new String(charArray);
            // mp.putIfAbsent(sortedSt, new ArrayList<>());
            // mp.get(sortedSt).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
}
