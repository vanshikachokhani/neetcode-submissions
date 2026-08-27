class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        int n = strs.length;
    
        for(int i=0;i<n;i++){
            String str = strs[i];
            int[] freq = new int[26];
            for(int j=0;j<str.length();j++){
                freq[str.charAt(j)-'a']++;
            }
            String freqStr = Arrays.toString(freq);
            mp.computeIfAbsent(freqStr, k -> new ArrayList<>()).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, List<String>>entry : mp.entrySet()){
            // System.out.println(entry.getKey() + " " + entry.getValue());
            ans.add(entry.getValue());
        }
        return ans;
    }
}
