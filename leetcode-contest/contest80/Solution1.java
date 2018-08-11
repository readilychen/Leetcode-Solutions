import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
class Solution1 {
    public String mostCommonWord(String paragraph, String[] banned) {
        StringTokenizer st = new StringTokenizer(paragraph," ");
        Map<String,Integer> resultMap = new HashMap<>();
        ArrayList<String> bannedList = new ArrayList<String>(Arrays.asList(banned));
        String finalWord = "";
        int count = Integer.MIN_VALUE;
        boolean isFirst = true;
        while(st.hasMoreElements()){
            String word = st.nextToken();
            char lasChar = word.charAt(word.length()-1);
            if(!((lasChar>=65&&lasChar<=90)||(lasChar>=97&&lasChar<=122))){
                 word = word.substring(0,word.length()-1);
            }
            word = word.toLowerCase();
            if(!bannedList.contains(word)){
                if(isFirst){
                    finalWord = word;
                    count = 1;
                    isFirst = false;
                }
                if(resultMap.containsKey(word)){
                    int tempcount = resultMap.get(word);
                    tempcount++;
                    if(tempcount > count){
                        count = tempcount;
                        finalWord = word;
                    }
                    resultMap.put(word,tempcount);
                }else{
                    resultMap.put(word,1);
                }
            }
        }
        return finalWord;
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        String[] banned = {""};
        System.out.println(s1.mostCommonWord("a.",banned));
    }
}