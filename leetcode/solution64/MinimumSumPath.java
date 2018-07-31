class MinimumSumPath{
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i == 0 && j == 0 ){
                    continue;
                }
                int leftValue = j - 1 >= 0 ? dp[i][j-1] : Integer.MAX_VALUE; 
                int upperValue = i - 1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE;
                dp[i][j] = leftValue < upperValue ? leftValue+grid[i][j] : upperValue+grid[i][j];
                // System.out.println(leftValue);
                // System.out.println(upperValue);
                // System.out.println("i  = "+ i);
                // System.out.println("j = "+ j);
                // System.out.println("dp = " + dp[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumSumPath msp = new MinimumSumPath();
        System.out.println(msp.minPathSum(grid));  
    }
}