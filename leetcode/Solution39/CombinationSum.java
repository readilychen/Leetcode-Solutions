import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays; 
class CombinationSum{
    List<Integer> canList = new ArrayList<>();
    List<Integer> resultList = new ArrayList<>();
    List<List<Integer>> finalResult = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findTarget(candidates,target);
        return finalResult;
    }


    public void findTarget(int[] candidates,int target){
        for(int i=0;i<candidates.length;i++){
            int remainValue = target-candidates[i];
            if(remainValue < 0){
                break;
            }else if(remainValue > 0){
               resultList.add(candidates[i]);
               findTarget(candidates,remainValue);
               if(resultList.size()>0){
                    resultList.remove(resultList.size()-1);
               } 
            }else{
                resultList.add(candidates[i]);
                int resultInt = 0;
                boolean hasValue = false;
                //System.out.println("*********");

                List<Integer> newTemp = new ArrayList<>();
                newTemp.addAll(resultList);
                
                Collections.sort(newTemp);
                for(int j = 0;j<newTemp.size();j++){
                    //System.out.println(newTemp.get(j));
                    hasValue = true;
                    resultInt *= 10;
                    resultInt += newTemp.get(j);
                }
                if(hasValue&&!canList.contains(resultInt)){
                    finalResult.add(newTemp);
                    canList.add(resultInt);
                }
                if(resultList.size()>0){
                     resultList.remove(resultList.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {1,2};
        int target = 4;
        List<List<Integer>> answer = cs.combinationSum(candidates,target);


        String s = "haha";
        String a =new String(s);
        System.out.println(s.equals(a));
    }
}