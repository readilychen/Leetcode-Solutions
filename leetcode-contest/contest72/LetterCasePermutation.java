import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
class LetterCasePermutation {
    List<String> resultString;
    public List<String> letterCasePermutation(String S){
        // resultString = new ArrayList<>();
        // resultString.add(S);
        // List<Integer> lock = new ArrayList<>();
        // int count = 0;
        // getList(lock,S,count);
        // return resultString;

        Set<String> resultSet = new HashSet<>();
        getList1(resultSet,S.toCharArray(),0);
        return new ArrayList<String>(resultSet);
    }
    public List<String> fullArrangement(String S){
        List<String> resultList = new ArrayList<String>();
        if(S.length() == 1){
            resultList.add(S);
            return resultList;
        }else{
         for(int i =0;i< S.length();i++){
            String start = String.valueOf(S.charAt(i));
                //System.out.println("start"+start);
            List<String> nextList = fullArrangement(S.substring(0,i)+S.substring(i+1,S.length()));
            for(String end: nextList ){
                resultList.add(start + end );
            }
        }
    }
    return resultList;
}
public void getList1(Set resultSet, char[] charArray, int index){
    resultSet.add(String.valueOf(charArray));
    for(int i =index;i<charArray.length;i++){
        if(Character.isLetter(charArray[i])){
            charArray[i] = Character.toUpperCase(charArray[i]);
            getList1(resultSet,charArray,i+1);
            charArray[i] = Character.toLowerCase(charArray[i]);
            getList1(resultSet,charArray,i+1);
        }
    }
}
public void getList(List<Integer> lock,String S,int count){
    count++;
    int start = lock.size();
    for(int i=start;i<S.length();i++){
        StringBuilder sb = new StringBuilder(S);
        char c = S.charAt(i);
        if(lock.contains(i)){
            continue;
        }else{
            char changeChar;
            if(c>=97&&c<=122){
             changeChar = (char)(c-97+65);
         }else if(c>=65&&c<=90){
             changeChar = (char)(c-65+97);
         }else{
            continue;
        }
        sb.replace(i,i+1,String.valueOf(changeChar));
        String targetS =sb.toString();
        if(!resultString.contains(targetS)){
            resultString.add(targetS);
            List<Integer> newLock = new ArrayList<>(lock);
            newLock.add(i);
            getList(lock,targetS,count);
        }
    }    
}
}
public static void main(String[] args) {
    // LetterCasePermutation lcp = new LetterCasePermutation();
    // List<String> result = lcp.fullArrangement("abcd");
    // System.out.println(result.size());
    // for(String s : result){
    //     System.out.println(s);
    // }
    LetterCasePermutation lcp = new LetterCasePermutation();
    for(String s: lcp.letterCasePermutation("abcd")) {    
        System.out.println(s);
    }
}
}