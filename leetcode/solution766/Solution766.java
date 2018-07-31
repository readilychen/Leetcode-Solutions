class Solution766{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m ;i++){
            int row = i;
            int column = 0;
            while(row < m-1 && column < n-1){
                if(matrix[row][column]!=matrix[++row][++column]){
                    return false;
                }
            }
        }
        for(int i = 0; i < n ; i++){
            int row = 0;
            int column = i;
            while(row < m-1 && column < n-1){
                if(matrix[row][column] != matrix[++row][++column]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,3,3,4},{5,1,2,3},{9,5,1,2}};
        Solution766 s766 = new Solution766();
        System.out.println(s766.isToeplitzMatrix(matrix));
    }
}