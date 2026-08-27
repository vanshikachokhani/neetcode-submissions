class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = m-1;
      int j = n-1;
      int r = n+m-1;
      
      while(i>=0 && j>=0 &&  r>=0){
        if(nums1[i]>=nums2[j]){
            nums1[r] = nums1[i];
            nums1[i] = 0;
            i--;
            r--;
        }
        else{
            nums1[r] = nums2[j];
            j--;
            r--;
        }
      }
      while(r>=0 && j>=0){
        nums1[r] = nums2[j];
        r--;
        j--;
      }
    }
}

// 3 20 20 0 0 40
// 3 0 0 20 20 40
// 2 4
