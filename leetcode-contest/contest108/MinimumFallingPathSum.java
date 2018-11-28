class MinimumFallingPathSum {
    int minSum = Integer.MAX_VALUE;
    int[][] record ;
    public int minFallingPathSum(int[][] A) {
        record = new int[A.length][A[0].length];
        for(int i=0; i<A[0].length; i++){
            int start = A[0][i];
            int min = findPath(A, 0, i);
            //System.out.println(min);
            minSum = minSum < min ? minSum : min;
        }
        
        return minSum;
    }
    public int findPath(int[][] A, int row, int col){
       
        if(row == A.length-1){
            record[row][col] = A[row][col];
            return A[row][col];
        }
        int threeValue = Integer.MAX_VALUE;
        if(col - 1 >= 0){
            if(record[row+1][col-1] != 0){
                threeValue = Math.min(threeValue, record[row+1][col-1]);
            }else{
                record[row+1][col-1] = findPath(A, row+1, col-1);
                threeValue = Math.min(threeValue, record[row+1][col-1]);
            }
        }
        if(record[row+1][col] != 0){
            threeValue = Math.min(threeValue, record[row+1][col]);
        }else{
            record[row+1][col] = findPath(A, row+1, col);
            threeValue = Math.min(threeValue, record[row+1][col]);
        }
        if(col + 1 < A[0].length){
            if(record[row+1][col+1] != 0){
                threeValue = Math.min(threeValue, record[row+1][col+1]);
            }else{
                record[row+1][col+1] = findPath(A, row+1, col+1);
                threeValue = Math.min(threeValue, record[row+1][col+1]);
            }
        }
        record[row][col] = threeValue + A[row][col];
        return record[row][col];
    }
}