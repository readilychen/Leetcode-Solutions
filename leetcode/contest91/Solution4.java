class Solution4{
    public int shortestSubarray(int[] A, int K) {
        int count = Integer.MAX_VALUE;
        int firstSum = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        for(int i = 0; i<A.length; i++){
            firstSum += A[i];
            if(firstSum >= K){
                rightIndex = i;
            }
        }
        if(firstSum == 0){
            return -1;
        }
        count = count < rightIndex + 1 ? count : rightIndex + 1;
        for(int i = rightIndex + 1; i< A.length; i++){
            if(A[i] <= 0){
                firstSum += A[i];
                rightIndex ++;
            }else{
                while(true){
                    if(A[leftIndex] <= 0){
                        leftIndex ++;
                        firstSum -= leftIndex;
                    }else{
                        if(firstSum - A[leftIndex] + A[rightIndex] <e1 K){

                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution4 s4 = new Solution4();

    }
}