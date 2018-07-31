import java.util.List;
import java.util.ArrayList;
class SplitArrayWithSameAverage{
    boolean flag = false;
    public boolean splitArraySameAverage(int[] A) {
        int sumA = 0;
        int lengthA =A.length;
        for(int i =0;i<lengthA;i++){
            sumA+=A[i];
        }
        float averageA = (float)sumA/lengthA;
        List<Integer> candidateLength = new ArrayList<Integer>();
        for(int i=1;i<=A.length/2;i++){
            if((sumA*i)%lengthA == 0){
                candidateLength.add(i);
            }
        }
        if(candidateLength.size() ==0){
            return false;
        }
        Integer finalCandiate = Integer.MIN_VALUE;
        for(Integer candidate : candidateLength){
            if(finalCandiate < candidate){
                finalCandiate = candidate;
            }
        }
        System.out.println("finalCandiate "+finalCandiate);
        List<Integer> resultList = new ArrayList<Integer>();
        recursivelyCheck(A,0,0,finalCandiate,averageA,resultList);
        return flag;
    }
    public void recursivelyCheck(int[] A, int sumLeft, int leftIndex, int length,float averageA,List<Integer> resultList){
        if(flag == true){
            return;
        }
        if(length == 0){
           
            float tempLeft = (float)(sumLeft)/2;
            System.out.println("averageA "+averageA);
            System.out.println("tempLeft "+tempLeft);
            for(Integer i:resultList){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    System.out.println("****");
            if(tempLeft == averageA){
                flag = true;
            }
            return;
        }
        for(int i = leftIndex;i<A.length;i++){
            int leftValue = sumLeft;
            if(leftValue == 0){
                leftValue = A[i];
            }else{
                    leftValue += A[i];
                    float tempLeft = (float)leftValue/2;
                    if(tempLeft == averageA){

                    for(Integer j:resultList){
                        System.out.print(j);
                    }
                     System.out.print(A[i]);
                    System.out.println();
                    System.out.println("****");

                    flag = true;
                    break;
                } 
            }
            resultList.add(A[i]);
            recursivelyCheck(A,leftValue,i+1,length-1,averageA,resultList);
            resultList.remove(resultList.size()-1);
        }
    }
    // public int[][] getAverageArray(int[] A){
    //     int arrlength = A.length;
    //     int[][] average = new int[arrlength][arrlength];
    //     average[0][0] = A[0];
    //     for(int i = 1;i<arrlength;i++){
    //         for(int j=i;j<arrlength;j++){
    //             if(i == j){
    //                 average[i][j] = A[i];
    //             }
    //             int nextAve = (average[i][j]+average[i][j-1]) >> 2;
    //             average[i][j] = nextAve;
    //         }
    //     }
    //     int totalAve = average[0][arrlength-1];
    // }
    public static void main(String[] args) {
        int[] A = {0,13,13,7,5,0,10,19,5};
        SplitArrayWithSameAverage sp = new SplitArrayWithSameAverage();
        System.out.println(sp.splitArraySameAverage(A));
    }
}