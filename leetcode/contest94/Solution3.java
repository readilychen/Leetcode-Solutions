import java.util.Arrays;
class Solution3{
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        if(piles.length == H){
            for(int i = 0; i<piles.length;i++ ){
                max = piles[i] > max ? piles[i] : max;
            }
            return max;
        }
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int startFrom = Math.cell((double)piles.length / H);
        
    }
    public int binarySearch(int start, int end){

    }
}
