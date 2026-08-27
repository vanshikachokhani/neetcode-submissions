class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            ans[i] = st.empty() ? 0 : -i+st.peek();
            st.push(i);
        }
        return ans;
    }
}
