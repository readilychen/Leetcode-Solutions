class Solution1{
    public int numMagicSquaresInside(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int count =0;
        for(int i =0;i<height;i++){
            for(int j=0;j<width;j++){
                if(height - i >= 3 && width - j >= 3){
                    int[] map = new int[16];
                    int firstRow = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                    int secondRow = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
                    int thirdRow = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                    int firstCol = grid[i][j] + grid[i+1][j] + grid[i+2][j];
                    int secondCol = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
                    int thirdCol = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
                    int diag = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                    if(firstRow == secondRow && secondRow == thirdRow && thirdRow == firstCol 
                        && firstCol == secondCol && secondCol == thirdCol && thirdCol == diag){
                        map[grid[i][j]] =1;
                        map[grid[i+1][j]] =1;
                        map[grid[i+2][j]] =1;
                        map[grid[i][j+1]] =1;
                        map[grid[i+1][j+1]] =1;
                        map[grid[i+2][j+1]] =1;
                        map[grid[i][j+2]] =1;
                        map[grid[i+1][j+2]] =1;
                        map[grid[i+2][j+2]] =1;
                        boolean flag = false;
                        for(int k = 1;k<10;k++){
                            if(map[k]!=1){
                                flag = true;
                                break;
                            }
                        }
                        if (!flag){
                            count ++;
                        }  
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid={{10,3,5},{1,6,11},{7,9,2}};
        Solution1 s1 = new Solution1();
        System.out.println(s1.numMagicSquaresInside(grid));
    }
}