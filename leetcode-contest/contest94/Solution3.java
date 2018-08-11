import java.util.Arrays;
class Solution3{
    public int minEatingSpeed(int[] piles, int H) {
        long totalPiles = 0;
        Arrays.sort(piles);
        for(int i = 0; i<piles.length;i++){
            totalPiles += piles[i];
        }
        int minPile = (int)Math.ceil(totalPiles /(double)H);
        int maxPile = piles[piles.length-1];
        while(minPile < maxPile){
            if(binarySearch(piles, minPile, H)){
                return minPile;
            }
            if(binarySearch(piles, (minPile + maxPile)/2 , H)){
                maxPile = (minPile + maxPile)/2;
            }else{
                minPile = (minPile + maxPile)/2+1;
            }
        }
        return minPile; 
    }
    public boolean binarySearch(int[] piles, int speed, int target){
        long count = 0;
        for(int p : piles){
            count += (int)Math.ceil(p/(double)speed);
        }
        return (int)count <= target;
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        int[] piles = {3,6,7,11};
        int H = 8;
        System.out.println(s3.minEatingSpeed(piles,H));
    }
}
