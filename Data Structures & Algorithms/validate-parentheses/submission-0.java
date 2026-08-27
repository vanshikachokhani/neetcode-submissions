class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            Character ch = s.charAt(i);
            if(s.charAt(i)=='[' || s.charAt(i) == '{' || s.charAt(i)=='(')
                st.push(s.charAt(i));
            else{
                if(st.empty()) return false;
                if((st.peek()!='[' && ch == ']') || (st.peek()!='(' && ch == ')') || (st.peek()!='{' && ch == '}'))
                    return false;
                else
                    st.pop();
            }     
        }
        return st.empty();
    }
}
