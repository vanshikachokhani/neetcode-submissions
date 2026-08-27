class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int totalGas = 0;
        int n = gas.length;
        int start = 0;

        for(int i=0;i<n;i++){
            currentGas = currentGas + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];
            if(currentGas<0){
                currentGas = 0;
                start = i+1;
            }
        }

        return totalGas<0 ? -1 : start;
    }
}
