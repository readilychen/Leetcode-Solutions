import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Solution1{
    public List<List<Integer>> largeGroupPositions1(String S){
        List<List<Integer>> finalList = new ArrayList<>();
        char comparedChar = S.charAt(0);
        int countNum = 1;
        for(int i = 1;i < S.length();i++){
            char nowChar = S.charAt(i);
            if(nowChar == comparedChar){
                countNum++;
            }else{
                if(countNum >= 3){
                    List<Integer> item = new ArrayList<>(); 
                    Integer first = i - countNum;
                    Integer second = i -1 ;
                    item.add(first);
                    item.add(second);
                    finalList.add(item);
                }
                comparedChar = nowChar;
                countNum = 1;
            }
        }
        if(countNum >= 3){
            List<Integer> item = new ArrayList<>(); 
            Integer first = S.length() - countNum;
            Integer second = S.length()-1;
            item.add(first);
            item.add(second);
            finalList.add(item);
        }
        return finalList;
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        Map<Integer,List<List<Integer>>> mydict = new HashMap<>();
        char comparedChar = S.charAt(0);
        int countNum = 1;
        for(int i = 1;i < S.length();i++){
            //the char is processing
            char nowChar = S.charAt(i);
            if(nowChar == comparedChar){
                countNum++;
            }else{
                if(countNum >= 3){
                    int indexInDict = comparedChar-97;
                    if(mydict.containsKey(indexInDict)){
                        List<Integer> item = new ArrayList<>(); 
                        Integer first = i - countNum;
                        Integer second = i -1 ;
                        item.add(first);
                        item.add(second);
                        mydict.get(indexInDict).add(item);
                    }else{
                        List<List<Integer>> itemList = new ArrayList<>();
                        List<Integer> item = new ArrayList<>();
                        Integer first = i - countNum;
                        Integer second = i -1 ;
                        item.add(first);
                        item.add(second);
                        itemList.add(item);
                        mydict.put(indexInDict,itemList);
                    }
                }
                comparedChar = nowChar;
                countNum = 1;
            }
        } 
        if(countNum >= 3){
                int indexInDict = S.charAt(S.length()-1)-97;
                if(mydict.containsKey(indexInDict)){
                    List<Integer> item = new ArrayList<>(); 
                    Integer first =  S.length() - countNum;
                    Integer second = S.length()-1 ;
                    item.add(first);
                    item.add(second);
                    mydict.get(indexInDict).add(item);
                }else{
                    List<List<Integer>> itemList = new ArrayList<>();
                    List<Integer> item = new ArrayList<>();
                    Integer first = S.length() - countNum;
                    Integer second = S.length()-1;
                    item.add(first);
                    item.add(second);
                    itemList.add(item);
                    mydict.put(indexInDict,itemList);
                }
        }  
        List<List<Integer>> finalList = new ArrayList<>();
        for(Integer key : mydict.keySet()){
            List<List<Integer>> itemList = mydict.get(key);
            for(List<Integer> item : itemList){
                finalList.add(item);
            }
        }
        return finalList;
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        String input = "abcdddeeeeaabbbcd";
        List<List<Integer>> result = s1.largeGroupPositions1(input);
        for(List<Integer> item : result){
            for(Integer i : item){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}