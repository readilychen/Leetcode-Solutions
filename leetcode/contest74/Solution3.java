import java.util.List;
import java.util.ArrayList;
class Solution3{
    List<List<Integer>> finalList = new ArrayList<>();
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        List<Integer> aListOfElem = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int processNum = A[i];
            int formerOne = i>0?A[i-1]:A[i];
            if( processNum <= R ){
                aListOfElem.add(A[i]);
            }else{
                if(aListOfElem.size() > 0){
                    addPossibleListToFinalList(aListOfElem,L,R);
                    aListOfElem.clear();
                    
                }
            }
        }
        if(aListOfElem.size() > 0){
            addPossibleListToFinalList(aListOfElem,L,R);
        }
        return finalList.size();
    }
    public void addPossibleListToFinalList(List<Integer> aListOfElem,int L,int R){

        List<Integer> newList = new ArrayList<>();
        
        for(int i =0;i<aListOfElem.size();i++){
            newList.clear();
            int max = Integer.MIN_VALUE;
            int firstElem = aListOfElem.get(i);
            max = firstElem>max?firstElem:max;
            newList.add(firstElem);
            if(firstElem >= L && firstElem <= R){
                List<Integer> addIn1 = new ArrayList<>(newList);
                finalList.add(addIn1);
            }
            for(int j=i+1;j<aListOfElem.size();j++){
                int element = aListOfElem.get(j);
                max = element>max?element:max;
                newList.add(element);
                if(max >= L && max <= R){
                    List<Integer> addIn2 = new ArrayList<>(newList);
                    finalList.add(addIn2);
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        int[] A= {73,55,36,5,55,14,9,7,72,52};
        int L = 32;
        int R = 69;
        System.out.println(s3.numSubarrayBoundedMax(A,L,R));

    }
}