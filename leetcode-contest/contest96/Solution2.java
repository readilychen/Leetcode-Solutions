import java.util.Map;
import java.util.HashMap;
class Solution2{
    public int numRescueBoats(int[] people, int limit) {
        int totalCount = 0;
        Map<Integer,Integer> peopleMap = new HashMap<>();
        //int maxWeight = Integer.MIN_VALUE;
        for(int i = 0; i < people.length; i++){
            if(people[i] == limit){
                totalCount++;
            }else{
                //maxWeight = maxWeight > people[i] ? maxWeight : people[i];
                if(peopleMap.containsKey(people[i])){
                    int number = peopleMap.get(people[i]);
                    peopleMap.put(people[i],number+1);
                }else{
                    peopleMap.put(people[i],1);
                }
            }
        }
        //System.out.println(peopleMap);
        for(int i = 0; i<people.length; i++){
            if(limit == people[i]){
                continue;
            }
            int count = peopleMap.get(people[i]);
            if(count != 0 ){
                peopleMap.put(people[i],count-1);
                int peopleWeight = people[i];
                int remainWeight = limit - peopleWeight;
                //System.out.println("remain weight "+ remainWeight);
                for(int j = remainWeight; j >0; j--){
                    if(peopleMap.get(j)!=null && peopleMap.get(j) != 0){
                        int remainCount = peopleMap.get(j);
                        peopleMap.put(j,remainCount-1);
                        break;
                    }
                }
                totalCount++;
            }
        }
        return totalCount;
    }
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit = 3;
        Solution2 s2 = new Solution2();
        System.out.println(s2.numRescueBoats(people,limit));
        
    }
}