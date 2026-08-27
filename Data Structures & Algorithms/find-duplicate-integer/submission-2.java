class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;

        for(int i=0;i<=n;i++){
            if(nums[i]<=n){
                if(nums[nums[i]-1]>n)
                    return nums[i];
                else{
                    nums[nums[i]-1] = nums[nums[i]-1] + n;
                }   
            }
            else{
                int q = nums[i]-n;
                if(nums[q-1]>n)
                    return q;
                else{
                    nums[q-1] = nums[q-1] + n;
                } 
            }
        }
        return 0;
    }
}

// 3,1,3,4,2
// n = 4

// 3 1 7 4 2
// 4 1 7 4 2 
// 4 1 7 

// 1 2 3 2 2
// n=4

// 5 6 7 

// 1 4 2 3 2
// n=4
// 5 4 2 7 2
// 5 8 2 7 2
// 5 8 6 7 2

