class Solution {
    public String simplifyPath(String path) {
        String[] dir  = path.split("/");
        Stack<String> st = new Stack<>();

        for(int i=0;i<dir.length;i++){
            if(dir[i].equals("..") && !st.isEmpty()){
                st.pop();
            }
            else if(dir[i].length()>0 && !dir[i].equals("..") && !dir[i].equals(".")){
                st.push(dir[i]);
            } 
        }
        List<String> temp = new ArrayList<>(st);
        return "/" + String.join("/", temp);
    }
}