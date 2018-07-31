import java.util.Map;
import java.util.HashMap;
class RabbitsInForest{
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int countRabbits = 0;
        if(answers.length == 0){
            return countRabbits;
        }
        for(int i = 0;i<answers.length;i++){    
            if(map.containsKey(answers[i])){
                int count = map.get(answers[i]);
                map.put(answers[i],++count);
            }else{
                map.put(answers[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(key == 0){
                countRabbits += value;
                continue;
            }
            if(value != 1 ){
                if((key+1) >= value){
                    countRabbits += 1 + key;
                }else{
                    int group = value/(key+1);
                    int left = value%(key+1);
                    if(left == 0){
                        countRabbits += (group) * (key + 1);
                    }else{
                        countRabbits += (group+1) * (key + 1);
                    }
                }   
            }else{
                countRabbits += key + 1;
            }
        }
        return countRabbits;
    }
    public static void main(String[] args) {
        int[] answers = {0,3,2,0,3,3,4,2,4,3,2,4,4,3,0,1,3,4,4,3};
        RabbitsInForest rif = new RabbitsInForest();
        System.out.println(rif.numRabbits(answers));
    }
}