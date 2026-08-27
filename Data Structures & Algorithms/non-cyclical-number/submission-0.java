class Solution {

    public int square(int n){
        int ans = 0;
        while(n>0){
            int d = n%10;
            n = n/10;
            ans = ans + d*d;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> st = new HashSet<>();
        int sq = square(n);
        
        while(st.contains(sq)==false){
            if(sq==1)
                return true;
            st.add(sq);
            n = sq;
            sq = square(n);
        }
        return false;
    }
}
