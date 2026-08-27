class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n || m==0) return "";

        Map<Character, Integer> mpt = new HashMap<>();
        Map<Character, Integer> mps = new HashMap<>();

        for(char c : t.toCharArray()){
            mpt.put(c, mpt.getOrDefault(c,0) + 1);
        }
        int[] ans = {-1,-1};
        int have = 0;
        int need = mpt.size();
        int l = 0;
        int resLen = Integer.MAX_VALUE;

        for(int r = 0;r<n;r++){
            mps.put(s.charAt(r),mps.getOrDefault(s.charAt(r),0)+1);

            if(mpt.containsKey(s.charAt(r)) && mps.get(s.charAt(r))==mpt.get(s.charAt(r)))
                have++;

            while(have==need){
                if(r-l+1<resLen){
                    resLen = r-l+1;
                    ans[0] = l;
                    ans[1] = r;
                }
                mps.put(s.charAt(l), mps.get(s.charAt(l))-1);
                if(mpt.containsKey(s.charAt(l)) && mps.get(s.charAt(l))<mpt.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
        }

        return resLen==Integer.MAX_VALUE ? "" : s.substring(ans[0], ans[1]+1);
    }
}
