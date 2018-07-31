import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution2{
    public int numFriendRequests(int[] ages) {
        int total_count = 0;
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        for(int i =0;i<ages.length;i++){
            if(countMap.containsKey(ages[i])){
                int count = countMap.get(ages[i]);
                countMap.put(ages[i],count+1);
            }else{
                countMap.put(ages[i],1);
            }
        }
        System.out.println(countMap);
        for(int i = 120;i>=2;i--){
            if(!countMap.containsKey(i)){
                continue;
            }
            for(int j = i-1;j>=1;j--){
                if(!countMap.containsKey(j)){
                    continue;
                } 
                //i must bigger than j   
                int counti = countMap.get(i);
                int countj = countMap.get(j);
                if(j <= 0.5 * i + 7){
                    break;
                }
                total_count += counti*countj;
            }
        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            int temp_count = entry.getValue();
            int temp_key = entry.getKey();
            if(temp_count>1){
                if(temp_key > 14){
                    total_count += factorial(temp_count-1) *2;
                }
            }
        }
        return total_count;
    }
    public int factorial(int a){
        if (a == 0){
            return 0;
        }
        return a + factorial(a-1);
    }
    
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[] ages1 = {16,16};
        System.out.println(s2.numFriendRequests(ages1));
    }
}