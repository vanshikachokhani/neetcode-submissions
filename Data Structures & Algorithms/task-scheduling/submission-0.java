class Solution {
    public int leastInterval(char[] tasks, int n) {
        char c;
        int freq = 0;
        Map<Character, Integer>mp = new HashMap<>();
        int m = tasks.length;
        for(int i=0;i<m;i++){
            mp.put(tasks[i], mp.getOrDefault(tasks[i],0)+1);
            if(freq<mp.get(tasks[i])){
                freq = Math.max(freq, mp.get(tasks[i]));
                c = tasks[i];
            }
        }
        int cnt=0;
        for(Character key : mp.keySet()){
            if(freq == mp.get(key)){
                cnt++;
            }
        }
        return Math.max(m, n*(freq-1) + freq + cnt-1);
    }
}
