class LongestPalindromicSubstring{
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        // it means the last half polindrome string starts at position i and end at position j, dp represent whether it form a continuous string;
        int[][] dp = new int[s.length()*2][s.length()*2];
        int maxi = 0;
        int maxj = 0;
        String longestSubString;
        int maxLength = Integer.MIN_VALUE;

        String longestSameString;
        int lastPos=0;
        int maxSameLength = Integer.MIN_VALUE;
        
        for(int i = 0; i<s.length()*2; i++){
            int tempCount = 1;
            int tempLastPos = 0;
            for(int j = i; j<s.length()*2; j++){
                if(i == j){
                    dp[i][j] = 1;
                }
                // else{
                //     if(s.charAt(i) == s.charAt(j)){
                //         tempCount++;
                //         tempLastPos = j;
                //     }else{
                //         break;
                //     }
                // }
            }
            // if(maxSameLength < tempCount){
            //     maxSameLength = tempCount;
            //     lastPos = tempLastPos;
            // }
        }
        //System.out.println("ddd"+maxSameLength);
        //System.out.println("hahahh"+lastPos);
        for(int i = 1 ; i < 2*s.length()-1; i++){
            for(int j = i-1; j >= 0; j--){
                if(2*j-i >= 0){
                    if((2*j-i) % 2 != 0 && i % 2 != 0){
                        if(dp[j][i-1] == 1){
                            dp[j][i] = 1;
                            int difference = i - j;
                                if(difference > maxLength){
                                    System.out.println("i"+i);
                                    System.out.println("j"+j);
                                    //maxi = j;
                                    //maxj = i;
                                    //maxLength = difference;
                                }
                            }
                    }else if((2*j-i) % 2 == 0 && i % 2 == 0){
                        if(s.charAt((2*j-i)/2) == s.charAt(i/2)){
                            System.out.println("this i "+i);
                            System.out.println("this j "+j);
                            if(dp[j][i-1] == 1){
                                dp[j][i] = 1;
                                int difference = i - j;
                                if(difference > maxLength){
                                    maxi = j;
                                    maxj = i;
                                    maxLength = difference;
                                }
                            }
                        }
                    }else{
                        continue;
                    }
                }
                
            }
        }
        System.out.println(maxi);
        System.out.println(maxj);

        StringBuilder sb = new StringBuilder();
        for(int i = 2*maxi-maxj; i< maxj+1; i++){
            if(i % 2 == 0){
                sb.append(s.charAt(i/2));
            }
        }
        return sb.toString();

        // if(maxSameLength > maxLength*2 + 1){
        //     return s.substring(lastPos-maxSameLength+1,lastPos+1);
        // }else{
        //     return s.substring(2*maxi-maxj,maxj+1);
        // }
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println("final string "+lps.longestPalindrome("abb"));
    }
}