class Solution {
    public List<String> fullJustify(String[] words, int maxWidth)   {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        int i =0 ;
        while(i<words.length){
            if(line.size()+length+words[i].length()<=maxWidth){
                line.add(words[i]);
                length+=words[i].length();
                i++;
            }
            else{
                if(line.size()==1){
                    StringBuilder sb = new StringBuilder();
                    sb.append(line.get(0));
                    for(int k=0;k<maxWidth - length;k++){
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    int totSpace = maxWidth - length;
                    int numSpaces = Math.max(1, line.size()-1);
                    int spcLength = totSpace/numSpaces;
                    int modSpc = totSpace%numSpaces;
                    for(int j=0;j<line.size();j++){
                        sb.append(line.get(j));
                        if(j<line.size()-1){
                            for(int k=0;k<spcLength;k++) sb.append(" ");
                            if(modSpc>0){
                                sb.append(" ");
                                modSpc--;
                            } 
                        }
                    }
                    res.add(sb.toString());
                }
                line.clear();
                length=0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<line.size();j++){
            sb.append(line.get(j));
            if(j<line.size()-1) sb.append(" ");
        }
        int blanks = maxWidth - length-line.size()+1;
        for(int j=0;j<blanks;j++){
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }
}
