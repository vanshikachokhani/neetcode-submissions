class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            leftMost[i] = -1;
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()==false)
                leftMost[i] = st.peek();
            
            st.push(i);
        }
        Stack<Integer> st2 = new Stack<>();

        for(int i=n-1;i>=0;i--){
            rightMost[i] = n;
            while(st2.isEmpty()==false && heights[st2.peek()]>=heights[i]){
                st2.pop();
            }
            if(st2.isEmpty()==false)
                rightMost[i] = st2.peek();
            st2.push(i);
        }

        int maxArea = 0 ;
        for(int i=0;i<n;i++){
            leftMost[i]+=1;
            rightMost[i]-=1;

            maxArea = Math.max(maxArea, heights[i]*(rightMost[i]-leftMost[i]+1));
        }
        return maxArea;
    }
}
