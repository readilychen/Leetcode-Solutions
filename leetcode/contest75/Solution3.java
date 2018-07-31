class Solution3{
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glassArray = new double[query_row+1][query_row+1];
        glassArray[0][0] = poured;
        for(int i = 0 ;i<query_row;i++){
            int j = i+1 ;
            System.out.println(" i "+i);
            for(int k =0;k<j;k++){
                System.out.println(" k "+k);
                if(glassArray[i][k]>1){
                    double addToNext = 0.5*(glassArray[i][k]-1);
                    glassArray[i][k] = 1;
                    glassArray[i+1][k] +=addToNext;
                    glassArray[i+1][k+1]+=addToNext;
                }
            }
        }
        double value = glassArray[query_row][query_glass]>1?1:glassArray[query_row][query_glass];
        return value;
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        System.out.println(s3.champagneTower(2,0,0));
    }
}