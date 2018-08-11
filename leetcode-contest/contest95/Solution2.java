import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution1{
    public boolean stoneGame(int[] piles) {
        List<Integer> pileList = new ArrayList<Integer>();
        for(int item : piles){
            pileList.add(item);
        }
        if(canWin(pileList,0,0,true)){
            return true;
        }else{
            return false;
        }
    }
    public boolean canWin(List<Integer> pileList, Integer countAlex, Integer countLee, boolean flag){
        if(pileList.size() == 1){
            countLee += pileList.get(0);
            return countAlex > countLee ;
        }
        if(pileList.size() == 0){
            return countAlex > countLee ;
        }

        int firstTry = pileList.get(0);
        if(flag){ 
            countAlex += firstTry;
        }else{
            countLee += firstTry;
        }
        pileList.remove(0);
        boolean firstTryFlag = canWin(pileList,countAlex,countLee,!flag);


        int lastTry = pileList.get(0);
        if(flag){
            countAlex += lastTry;
        }else{
            countLee += lastTry;
        }
        pileList.add(0,firstTry);
        pileList.remove(pileList.size()-1);
        boolean secondTryFlag = canWin(pileList,countAlex,countLee,!flag);
        return firstTryFlag || secondTryFlag;
    }
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        Solution1 s1 = new Solution1();
        System.out.println(s1.stoneGame(piles));
    }
}