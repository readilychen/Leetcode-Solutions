import java.util.regex.*;
class Solution2{
    public int numMatchingSubseq(String S, String[] words) {
        int count =0;
        for(int i=0;i<words.length;i++){
            String targetWord = words[i];
            int originalLength = targetWord.length();
            //process the targetWord to the regex pattern
            targetWord = "[a-z]*" + targetWord;
            for(int j = 1;j<=originalLength;j++){
                targetWord  = targetWord.substring(0,j*6+j) + "[a-z]*" + targetWord.substring(j*6+j,targetWord.length());
            }
            boolean isMatch = Pattern.matches(targetWord,S);
            if(isMatch){
                count++;
            }
        }
        return count;
    }

    public boolean recurisivelySearch(String target, String word){
        if(word.length()!= 0 ){
            char targetChar = word.charAt(0);
            
            for(int i=0;i<target.length();i++){
                if(target.charAt(i) == targetChar){
                    return recurisivelySearch(target.substring(i+1,target.length()),word.substring(1,word.length()));
                }
            }
        }else{
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        Solution2 s2 = new Solution2();
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(s2.numMatchingSubseq(S,words));
    }
}