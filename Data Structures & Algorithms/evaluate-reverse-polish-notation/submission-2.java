class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        st.push(Integer.parseInt(tokens[0]));
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        st.push(Integer.parseInt(tokens[1]));

        for(int i=2;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    st.push(-st.pop() + st.pop());
                    break;
                case "/":
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second / first);
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                default:
                    st.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }    
        return st.pop();
    }
}
