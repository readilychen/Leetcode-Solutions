class Solution1{
    public int projectionArea(int[][] grid) {
        int xy = 0;
        int xz = 0;
        int yz = 0;
        int[] yzArray = new int[grid[0].length];
        for(int i = 0 ; i < grid.length; i++){
            int rowMax = Integer.MIN_VALUE;
            for(int j = 0; j< grid[0].length;j++){
                rowMax = rowMax > grid[i][j] ? rowMax : grid[i][j];
                yzArray[j] = yzArray[j] > grid[i][j] ? yzArray[j] : grid[i][j];
                if(grid[i][j]!=0){
                    xy++;
                }
            }
            xz+=rowMax;
        }
        for(int i : yzArray){
            yz += i;
        }
        return xy + xz + yz;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        Solution1 s1 = new Solution1();
        System.out.println(s1.projectionArea(grid));
    }
}