class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][3];

        for(int i=0;i<n;i++){
            cars[i][0] = position[i];;
            cars[i][1] = speed[i];
            cars[i][2] = (double) (target - position[i]) / speed[i];
        } 
        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int ans = 1;

        double lastTime = cars[0][2];

        for(int i=1;i<n;i++){
            System.out.println(cars[i][0] + " " + cars[i][1] + " " + cars[i][2]);
            if(cars[i][2]>lastTime){
                ans++;
                lastTime = cars[i][2];
            }
        }
        return ans;

    }
}

// 8 4 
// 7 4 1.7
// 6 4 1.5
// 5 4 1.25
// 4 4 1
// 3 4 0.75
