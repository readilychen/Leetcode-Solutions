import java.util.List;
import java.util.ArrayList;
class Solution2{
    //List<Integer> positionList = new ArrayList<Integer>();
    boolean flag =false;
    public boolean reorderedPowerOf2(int N) {
        List<Integer> toList = new ArrayList<Integer>();
        while(N != 0){
            Integer item = N % 10; 
            N /= 10;
            toList.add(item);
        }
        recursivelySearch(toList,0);
        return flag;
        
    }
    public void recursivelySearch(List<Integer> candidate,int value){
        if(candidate.size() == 0){
            System.out.println("hahah "+value);
            if(isPowerOfTwo(value)){
                flag = true;
                return;
            }
        }
        for(int i = 0;i<candidate.size();i++){ 
            Integer item = candidate.get(i);
            if(value == 0 && item == 0){
                continue;
            }
            //positionList.add(i);
            System.out.println("item " + item);
            System.out.println("value "+ value);
            value *= 10;
            value += item;
            System.out.println("after "+value);
            System.out.println(candidate);
            System.out.println();
            candidate.remove(i);
            recursivelySearch(candidate,value);
            candidate.add(i,item);
            value -= item;
            value /= 10;
            System.out.println("after can: "+candidate);
        }
    }
    public boolean isPowerOfTwo(int n){
        return n>0 && (n&n-1)==0;
    }
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<Integer>();
        Solution2 s2 = new Solution2();
        System.out.println(s2.reorderedPowerOf2(1));
    }
}