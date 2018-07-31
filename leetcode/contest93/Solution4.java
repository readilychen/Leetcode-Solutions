class Solution4{
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int startFuel = startFuel;
        int startPoint = 0;

        int maxStartFule = Integer.MIN_VALUE;
        int maxPositionIndex= 0;
        int i = 0;
        int minCount = 0;
        while(true){
            if(startPoint + startFuel >= target){
                break;
            }
            if(stations[i][0] <= startFuel + startPoint && i < stations.length){
                int stopAtThatPosition = startFuel + startPoint - stations[i][0] + stations[i][1];
                if(maxStartFule < stopAtThatPosition){
                    maxStartFule = stopAtThatPosition;
                    maxPositionIndex = i;
                }
                i++;
            }else{
                i = maxPositionIndex;
                startPoint = stations[i][0];
                startFuel = maxStartFule;
                minCount ++;
            }
        }
        return minCount;
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length];
        int startFuel = startFuel;
        int startPoint = 0;

        int i = 0;
        int minCount = 0;
        while(true){
            if(startPoint + startFuel >= target){
                break;
            }
            if(){
                
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
[[5,20],[10,60](10,60),[20,30],[30,30],[60,40]]
target = 100, startFuel = 10
25,60, 80,70,50