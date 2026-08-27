class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                nums[i] = 0;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int val = Math.abs(nums[i]);
                if(val>=1 && val<=n){
                    if(nums[val-1]==0){
                        nums[val-1] = -1*(val);
                    }
                    else if(nums[val-1]>0){
                        nums[val-1] = -1*nums[val-1];
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
            if(nums[i]>=0)
                return i+1;
        }
        return n+1;
    }
}

// [0,-1,-1*(2),-4,-2,-4,-5,6,3,1]