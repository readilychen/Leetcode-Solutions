import java.util.ArrayList;
import java.util.List;
class ReverseInteger{
    public int reverse(int x){
        boolean isNeg = false;
        if(x < 0){
            x*=-1;
            isNeg = true;
        }
        long result = 0;
        while(x != 0){
            int a = x % 10;
            x/=10;
            result = (result*10 + a);
            //i++;
        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        }
        
        if(isNeg){
            return (int)(-1*result);
        }else{
            return (int)result;
        }
    }

    public String reverseRecursively(int x){
        int a = 0;
        if(x != 0){
            a=x%10;
            x/=10;
        }
        return String.valueOf(a)+reverseRecursively(10);
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-1534236469));
    }
}