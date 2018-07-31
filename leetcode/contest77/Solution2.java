import java.util.List;
import java.util.ArrayList;
class Solution2{
    public int uniqueMorseRepresentations(String[] words) {
        List<String> resultString = new ArrayList<>();
        String[] searchTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(int i =0;i<words.length;i++){
            String transformStr = "";
            for(int j =0;j<words[i].length();j++){
                int value = words[i].charAt(j) - 97;
                transformStr += searchTable[value];
            }
            System.out.println(transformStr);
            if(!resultString.contains(transformStr)){
                resultString.add(transformStr);
            }
        }
        return resultString.size();
    }
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Solution2 s2 = new Solution2();
        System.out.println(s2.uniqueMorseRepresentations(words));
    }
}