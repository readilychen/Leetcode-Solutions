import java.util.StringTokenizer;

class Solution1{
    public String toGoatLatin(String S) {
        StringTokenizer st = new StringTokenizer(S);
        String resultStr = "";
        int count = 1;
        if(S.length() == 0){
            return "";
        }else if(S.length() ==1 ){
            return processStr(S,count);
        }
        while(st.hasMoreElements()){
            String preprocessedStr = st.nextToken();
            String afterProcessStr = processStr(preprocessedStr,count);
            resultStr += afterProcessStr + " ";
            count++;
        }
        return resultStr.substring(0,resultStr.length()-1);
    }
    public String processStr(String preprocessedStr,int count){
        if(preprocessedStr.charAt(0) == 'a' || preprocessedStr.charAt(0) == 'e' || preprocessedStr.charAt(0) == 'i'
                || preprocessedStr.charAt(0) == 'o'|| preprocessedStr.charAt(0) == 'u'||preprocessedStr.charAt(0) == 'A' || preprocessedStr.charAt(0) == 'E' || preprocessedStr.charAt(0) == 'I'
                || preprocessedStr.charAt(0) == 'O'|| preprocessedStr.charAt(0) == 'U'){
                preprocessedStr += "ma";
            }else{
                char firstChar = preprocessedStr.charAt(0);
                preprocessedStr = preprocessedStr.substring(1,preprocessedStr.length());
                preprocessedStr += firstChar;
                preprocessedStr += "ma";
            }
            for(int i =0;i<count;i++){
                preprocessedStr += 'a';
            }
            return preprocessedStr;
    }
    public static void main(String[] args) {
        String input = "The quick brown fox jumped over the lazy dog";
        Solution1 s1 = new Solution1();
        System.out.println(s1.toGoatLatin(input));
    }
}