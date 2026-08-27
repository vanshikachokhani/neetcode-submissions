class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==0) return 0;
        double ans = helper(x,Math.abs(n));
        return n<0 ? 1/ans : ans;
    }

    public double helper(double x, int n){
        if(n==0)
            return 1;
        double half = helper(x,n/2);
        return (n%2==1) ? half*half*x : half*half;
    }
}
