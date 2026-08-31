class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0 ;
        int n = matchsticks.length;
        for(int i=0;i<n;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0) return false;
        Arrays.sort(matchsticks);
        int length = sum/4;
        int[] sides = new int[4];
        return dfs(matchsticks, length, n-1, sides);
    }

    public boolean dfs(int[] matchsticks, int length, int id, int[] sides){
        System.out.println("First" + id);
       if(id<0){
          return true;
       } 
       for(int i=0;i<4;i++){
        if(matchsticks[id] + sides[i] <= length){
            System.out.println("Second" + id + " " + i);
            sides[i]+=matchsticks[id];
            if(dfs(matchsticks, length, id-1, sides)) 
                return true;
            sides[i]-=matchsticks[id];
        }
        if(sides[i]==0){
            System.out.println("Third" + id);
         break;
        }
       }
       return false;
    }
}