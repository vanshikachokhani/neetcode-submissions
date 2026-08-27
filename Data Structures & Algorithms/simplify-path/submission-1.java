class Solution {
    public String simplifyPath(String path) {
        String[] dir  = path.split("/");
        Stack<String> st = new Stack<>();

        for(int i=0;i<dir.length;i++){
            if(dir[i].equals("..") && st.isEmpty()==false){
                st.pop();
            }
            else if(dir[i].length()>0 && dir[i].equals("..")==false && dir[i].equals(".")==false){
                st.push(dir[i]);
            } 
        }
        List<String> temp = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        while(st.isEmpty()==false){
            temp.add(st.peek());
            st.pop();
        }

        for(int i=temp.size()-1;i>=0;i--){
            ans.append("/");
            ans.append(temp.get(i));
        }
        return ans.toString().length()==0 ? "/" : ans.toString();
    }
}