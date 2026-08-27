class Solution {
    public int binarySearch(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right = mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        
        int n = nums.length;
        int start = binarySearch(nums, target);
        if(start==n || nums[start]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{start, binarySearch(nums,target+1)-1};
    }
}

// 5 8 8 8 8 10