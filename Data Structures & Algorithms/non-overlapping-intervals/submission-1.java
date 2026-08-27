class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int prevEnd = intervals[0][1];
        int ans = 0;

        int i = 1;
        int n = intervals.length;
        while(i<n){
            if(intervals[i][0]<prevEnd){
                ans++;
            }
            else{
                prevEnd = intervals[i][1];
            }
            i++;
        } 
        return ans;   
    }
}
