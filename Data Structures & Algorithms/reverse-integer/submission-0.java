class Solution {
    public int reverse(int x) {
        int ans = 0 ;
        int temp = x;

        int MIN = -(1<<31);
        int MAX = (1<<31)-1;
        System.out.println(MIN + " " + MAX);

        while(temp!=0){
            int digit = temp%10;
            temp = temp/10;
            if(ans > MAX/10 || ans==MAX/10 && digit > MAX%10) return 0;
            if(ans< MIN/10 || ans==MIN/10 && digit < MIN%10) return 0;
            ans = ans*10 + digit;
        }
        return ans;
    }
}
