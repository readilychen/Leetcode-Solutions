class KnightDialer {
    public int knightDialer(int N) {
        int[][] press = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        long[][] dp = new long[10][N+1];
        for(int i=0; i<dp.length; i++){
            dp[i][1] = 1;
        }
        for(int i = 2; i<N+1; i++){
            for(int j=0; j<10; j++){
                long num = 0;
                for(int k= 0; k<press[j].length; k++){
                    num += dp[press[j][k]][i-1];
                }
                dp[j][i] = num % 1000000007;
            }
        }
        long res = 0;
        for(int i=0; i<10; i++){
            res += dp[i][N];
        }
        return (int)(res % 1000000007);
    }
}