class Solution {

    public String longestPrefix(String a, String b){
        int i = 0;
        int j = 0;
        while(i<a.length() && j<b.length() && a.charAt(i) == b.charAt(j)){
            i++;
            j++;
        }
        return a.substring(0,i);
    }

    public String longestCommonPrefix(String[] str) {
        int n = str.length;
        for(int i=0;i<str.length-1;i++){
            str[i+1] = longestPrefix(str[i], str[i+1]);

            if(str[i+1]==""){
                return "";
            }
        }
        return str[n-1];
    }

}