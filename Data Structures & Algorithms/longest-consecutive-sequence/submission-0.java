class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num:nums){
            st.add(num);
        }
        int ans = 0;

        for(Integer num : st){
            if(st.contains(num-1)==false){
                int len = 1;
                while(st.contains(num+len)){
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;

    }
}

// 0 1 2  4 5 6 