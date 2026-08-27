class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // List<List<Integer>> ans = new ArrayList<>();

        // for(int i=0;i<n-2;i++){
        //     if(i>0 && nums[i]==nums[i-1])
        //         continue;
        //     int target = -nums[i];
        //     int left = i+1;
        //     int right = n-1;

        //     while(left<right){
        //         int sum = nums[left] + nums[right];
        //         if(sum==target){
        //             ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
        //             while(left<right && nums[left] == nums[left+1])
        //                 left++;
        //             while(left<right && nums[right] == nums[right-1])
        //                 right--;
                    
        //         }
        //         else if(sum < target){
        //             left++;
        //         }
        //         else
        //             right--;
        //     }
        // }
        // return ans;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
    
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int target = -nums[i];
            int front = i+1;
            int back = nums.length-1;

            while(front<back){
                int sum = nums[front] + nums[back];
                if(sum<target)
                    front++;
                else if(sum>target)
                    back--;
                else{
                    ans.add(Arrays.asList(nums[i],nums[front],nums[back]));
                    while(front<back && nums[front]==nums[front+1])
                        front++;
                    while(front<back && nums[back]==nums[back-1])
                        back--;
                    
                    front++;
                    back--;
                }
            }
        }
        return ans;
    }
}
