class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        boolean flag = false;
        if(A[1] < A[0]){
            return false;
        }
        for(int i=0; i<A.length-1; i++){
            if(A[i+1] == A[i]){
                return false;
            }
            if(A[i+1] < A[i] && !flag){
                flag = true;
            }
            if(flag && A[i+1] > A[i]){
                return false;
            }
        }
        if(!flag){
            return false;
        }
        return true;
    }
}