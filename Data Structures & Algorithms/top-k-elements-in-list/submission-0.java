class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) mp.put(num,mp.getOrDefault(num,0)+1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));

        for(int key : mp.keySet()){
            heap.add(key);
        }

        int[] ans = new int[k];

        for(int i=0;i<k;i++){
            ans[i] = heap.poll();
        }
        return ans;
    }
}
