class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int p = pq.poll();
            int q = pq.poll();
            if(p!=q){
                pq.add(Math.abs(p-q));
            }
        }
        return(pq.size()==0)? 0 : pq.poll();
    }
}
