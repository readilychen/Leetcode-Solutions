import java.util.List;
import java.util.ArrayList;
class CustomSortString{
    public String customSortString(String S, String T) {
        char[] startChars = S.toCharArray(); 
        char[] newChars = new char[T.length()];
        List<Character> mylist = new ArrayList<>();
        int k = 0;
        for(int i=0;i<startChars.length;i++){
            char start = startChars[i];
            mylist.add(start);
            System.out.println(start);
            for(int j=0;j<T.length();j++){
                if(start == T.charAt(j)){
                    //T1=T1.substring(0,j)+T1.substring(j+1,T1.length());
                    newChars[k] = start;
                    k++;
                }
            }
        }
        for(int l = 0;l<T.length();l++){   
            if(!mylist.contains(T.charAt(l))){
                newChars[k] = T.charAt(l);
                k++;
            }
        }
        return String.valueOf(newChars);
    }
    public static void main(String[] args) {
         CustomSortString css = new CustomSortString();
         System.out.println(css.customSortString("abc","accccbbsd"));
    }
}