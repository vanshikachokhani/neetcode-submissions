class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int n = nums.length;
        int i = 0;

        while(i<n){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
                i++;
            }
            else{
                i++;
            }
        }
        
        for(int q=0;q<n;q++) System.out.println(nums[q]);
        return k;
    }
}