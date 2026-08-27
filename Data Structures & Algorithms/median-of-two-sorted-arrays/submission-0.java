class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int median1 = 0, median2 = 0;

        int i = 0; int j=0; int cnt = 0;
        double ans = 0;

        while(cnt<(n+m)/2+1){
            median1 = median2;
            if(i<n && j<m && nums1[i]<nums2[j]){
                median2 = nums1[i];
                i++;
            }
            else if(i<n && j<m && nums2[j]<nums1[i]){
                median2 = nums2[j];
                j++;
            }
            else if(i<n){
                median2 = nums1[i];
                i++;
            }
            else if(j<m){
                median2 = nums2[j];
                j++;
            }
            cnt++;
        }
        System.out.println(median1 + " " + median2);
        if((n+m)%2==0){
            ans = (median1+median2)/2.0;
        }
        else{
            ans  = median2;
        }
        return ans;
    }
}
