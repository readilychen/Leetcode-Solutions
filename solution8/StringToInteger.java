class StringToInteger {
    public int myAtoi(String str) {
        //System.out.println(Long.valueOf(str));
        long result = 0;
        boolean isFirst = true;
        boolean isNeg = false;
        for(int i = 0; i< str.length(); i++){
            if(isFirst){
                if(str.charAt(i)=='-'){
                    //System.out.println("HAHAH");
                    isNeg = true;
                    isFirst = false;
                }else if(str.charAt(i)=='+'){
                    isNeg = false;
                    isFirst = false;
                }else if(str.charAt(i) >= 48  && str.charAt(i) <= 57){
                    result *= 10;
                    result += (Integer.valueOf(str.charAt(i))-48);
                    isFirst = false;
                }else if(str.charAt(i) == ' '){
                    continue;
                }else{
                    return 0;
                }
            }else{
                if(str.charAt(i) >= 48  && str.charAt(i) <= 57){
                    result *= 10;
                    result += (Integer.valueOf(str.charAt(i))-48);
                    //System.out.println(result);
                    if(result > Integer.MAX_VALUE){
                        if(!isNeg){
                            return Integer.MAX_VALUE;
                        }
                    }
                    if(isNeg){
                        
                        if((result*-1) < Integer.MIN_VALUE){
                            return Integer.MIN_VALUE;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        System.out.println(result);
        if(isNeg){
            result = -1 * result;
        }
        
        
        return (int)result;
    }
    public static void main(String[] args) {
        String str = "42";
        StringToInteger sti = new StringToInteger();
        sti.myAtoi(str);
    }
}