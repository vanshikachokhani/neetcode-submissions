class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            int freq[] = new int[26];

            for(int j=0;j<strs[i].length();j++){
                freq[strs[i].charAt(j) - 'a']++;
            }
            String count = Arrays.toString(freq);
            mp.putIfAbsent(count, new ArrayList<>());
            mp.get(count).add(strs[i]);
        }

        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
