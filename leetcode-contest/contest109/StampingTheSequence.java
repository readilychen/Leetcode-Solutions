import java.util.List;
import java.util.ArrayList;
class StampingTheSequence {
    //aabcaca
    //abca
    public int[] movesToStamp(String stamp, String target) {
        if(stamp.charAt(0)!=target.charAt(0) || stamp.charAt(stamp.length-1) != target.charAt(target.length-1)){
            return new int[0];
        }
        int m = stamp.length;
        int n = target.length;
        
    }
}