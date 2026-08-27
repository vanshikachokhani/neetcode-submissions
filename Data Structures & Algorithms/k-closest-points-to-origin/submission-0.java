class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] left, int[] right){
                return getDistance(right)-getDistance(left);
            }
        });
        
        for(int[] point:points){
            pq.add(point);
            if(pq.size()>k)
                pq.poll();
        }

        int i = 0;
        while(k>0){
            ans[i] = pq.poll();
            i++;
            k--;
        }

        return ans;
    }

    public int getDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
