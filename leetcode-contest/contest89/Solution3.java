import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
class Solution3 {
    Map<Integer,List<Integer>> richerMap = new HashMap<>();
    Map<Integer,Integer[]> indexMap = new HashMap<>();
    public Integer[] recursivelySearch(int target,int[] quiet){
        System.out.println(target);
        if(indexMap.containsKey(target)){
            return indexMap.get(target);
        }else{
            List<Integer> itemList = richerMap.get(target);
            Integer[] globalitemMin = new Integer[2];
            globalitemMin[0] = target;
            globalitemMin[1] = quiet[target];
            for(Integer item : itemList){
                Integer[] itemMin = recursivelySearch(item,quiet);
                if(itemMin[1] < globalitemMin[1]){
                    globalitemMin[0] = itemMin[0];
                    globalitemMin[1] = itemMin[1];
                }
            }
            indexMap.put(target,globalitemMin);
            return globalitemMin;
        }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] answer = new int[quiet.length];
        for(int i =0;i<richer.length;i++){
            int x = richer[i][0]; //1
            int y = richer[i][1]; //2
            List<Integer> itemList = null;
            if(richerMap.containsKey(y)){
                itemList = richerMap.get(y);
                itemList.add(x);
            }else{
                itemList = new ArrayList<>();
                itemList.add(x);
                richerMap.put(y,itemList);
            }   
        }
        for(Integer key : richerMap.keySet()){
            System.out.println("key is "+ key);
            for(Integer item : richerMap.get(key)){
                System.out.println("item is : "+ item);
            }
            System.out.println();
        }
        for(int i = 0; i < quiet.length;i++){
            if(!richerMap.containsKey(i)){
                Integer[] minQuiet = new Integer[2];
                minQuiet[0] = i;
                minQuiet[1] = quiet[i];
                indexMap.put(i,minQuiet);
            }
        }
        for(int j = 0;j < quiet.length;j++){
            Integer[] result = recursivelySearch(j,quiet);
            answer[j] = result[0];
        }
        
        // for(int j = 0; j<quiet.length ;j++){
        //     int min = quiet[j];
        //     int globalitem = j;
        //     // if the richermap does not contain the item
        //     if(richerMap.containsKey(j)){
        //         for(Integer equalOrLarger : richerMap.get(j)){
        //             if(richerMap.containsKey(equalOrLarger)){
        //                 Integer[][] leastQuiet = indexMap.get(equalOrLarger);
        //                 if(leastQuiet[0][1] < min){
        //                     min = leastQuiet[0][1];
        //                     globalitem = leastQuiet[0][0];
        //                 }
        //             }
        //         }
        //     }
        //     answer[j] = globalitem;
        // }
        return answer;
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        int[] result = s3.loudAndRich(richer,quiet);
        for(int i =0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }
}