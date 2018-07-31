class DecodedWays{
    // tabulation solution from bottom to up
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0) - 48 >= 1 && s.charAt(0)-48 <= 26){
            dp[0] = 1;
            dp[1] = 1;
        }else{
            return 0;
        }
        for(int i = 1;i<s.length();i++){
            int digit1 = Integer.valueOf(s.charAt(i-1))-48;
            int digit2 = Integer.valueOf(s.charAt(i))-48;
            if(digit1*10 + digit2 >=1 && digit1*10 + digit2 <= 26 && digit1 != 0){
                if(digit2 != 0 ){
                    dp[i+1] = dp[i + 1 -1] + dp[i+1-2];  
                }else{
                    dp[i+1] = dp[i + 1 - 2];
                }  
            }else{
                if(digit2 != 0){
                    dp[i+1] = dp[i + 1 -1];
                }else{
                    return 0;
                }  
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        DecodedWays dw = new DecodedWays();
        String s = "110";
        System.out.println(dw.numDecodings(s));
    }
}