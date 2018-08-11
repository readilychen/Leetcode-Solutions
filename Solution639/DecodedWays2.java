class DecodedWays2{
    // tabulation solution from bottom to up
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0) - 48>=1 && s.charAt(0)-48 <= 26){
            dp[0] = 1;
            dp[1] = 1;
        }else if(s.charAt(0) == '*'){
            dp[0] = 1;
            dp[1] = 9;
        }else{
            return 0;
        }
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '*'){
                if(s.charAt(i-1) == '*'){
                    dp[i+1] = dp[i+1-2] * 15 + dp[i+1-1]*9; 
                }else if(s.charAt(i-1) == '0'){
                    dp[i+1] = dp[i+1-1] * 9;
                }else{
                    if(Integer.valueOf(s.charAt(i-1))-48 == 1){
                        dp[i+1] = dp[i+1-2] * 9 + dp[i+1-1] * 9;
                    }else if(Integer.valueOf(s.charAt(i-1))-48 == 2){
                        dp[i+1] = dp[i+1-2] * 6 + dp[i+1-1] * 9; 
                    }else{
                        dp[i+1] = dp[i+1-1] * 9;
                    }
                }
            }else if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '*'){
                    dp[i+1] = dp[i+1-2] * 2;
                }else if(s.charAt(i-1) == '0'){
                    return 0;
                }else{
                    dp[i+1] = dp[i+1-1] + 1;
                }
            }else{
                if(s.charAt(i-1) == '*'){
                    if(Integer.valueOf(s.charAt(i))-48 == 0){
                        dp[i+1] = dp[i+1-2]*2;
                    }else if(Integer.valueOf(s.charAt(i))-48 <= 6){
                        dp[i+1] = dp[i+1-2]*2 + dp[i+1-2] * 9;
                    }else{
                        dp[i+1] = dp[i+1-2] + dp[i+1-2] * 9;
                    }
                }else if(s.charAt(i-1) == '0'){
                    dp[i+1] = dp[i+1-1];
                }else{
                    int digit1 = Integer.valueOf(s.charAt(i-1))-48;
                    int digit2 = Integer.valueOf(s.charAt(i))-48;
                    if(digit1*10 + digit2 >=1 && digit1*10 + digit2 <= 26 ){
                        dp[i+1] = dp[i + 1 -1] + dp[i+1-2];
                    }else{
                        dp[i+1] = dp[i + 1 -1];
                    }
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        
    }
}