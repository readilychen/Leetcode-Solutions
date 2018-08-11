class Solution3{
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] topbottomSkyline = new int[grid[0].length];
        int[] leftrightSkyline = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int rowMax = Integer.MIN_VALUE;
            int colMax = Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++){
                rowMax = grid[i][j] < rowMax?rowMax:grid[i][j];
                colMax = grid[j][i] < colMax?colMax:grid[j][i];
            }
            topbottomSkyline[i] = colMax;
            leftrightSkyline[i] = rowMax;
        }
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                int addTo = topbottomSkyline[j]>leftrightSkyline[i]?leftrightSkyline[i]:topbottomSkyline[j];
                count += addTo - grid[i][j];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        Solution3 s3 = new Solution3();
        System.out.println(s3.maxIncreaseKeepingSkyline(grid));
    }
}