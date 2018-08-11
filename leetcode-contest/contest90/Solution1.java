import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class Solution1 {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        List<Integer> diffPosition = new ArrayList<>();
        Map<Character,Integer> repMap = new HashMap<>();
        for(int i =0; i < A.length(); i++){
            if(A.charAt(i)!=B.charAt(i)){
                diffPosition.add(i);
            }
            if(A.length() < 26){
                if(repMap.containsKey(A.charAt(i))){
                    Integer newValue = repMap.get(A.charAt(i));
                    newValue+=1;
                    repMap.put(A.charAt(i),newValue);
                }else{
                    repMap.put(A.charAt(i),1);
                }
            }
        }
        if(diffPosition.size() == 2){
            int firstPos = diffPosition.get(0);
            int secondPos = diffPosition.get(1);
            if(A.charAt(firstPos) == B.charAt(secondPos) && A.charAt(secondPos) == B.charAt(firstPos)){
                return true;
            }else{
                return false;
            }
        }else if(diffPosition.size() == 0){
            if(A.length() > 26){
                return true;
            }else{
                for(Character c : repMap.keySet()){
                    if(repMap.get(c) > 1){
                        return true;
                    }
                }
                return false;
            }
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        String A = "aa";
        String B = "aa";
        System.out.println(s1.buddyStrings(A,B));
    }
}