class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int totalA = 0;
        for(int i = 0; i<A.length; i++){
            totalA += A[i];
        }
        int totalB = 0;
        for(int i = 0; i<B.length; i++){
            totalB += B[i];
        }
        boolean flag = false;
        int difference = 0;
        if(totalA > totalB){
            flag = true;
            difference = totalA - totalB;
        }else{
            difference = totalB - totalA;
        }
        difference /= 2;
        if(flag){
            for(int i = 0; i<A.length; i++){
                int changeA = A[i];
                int changeB = changeA - difference;
                if(isExist(B,0,B.length-1,changeB)){
                    return new int[]{changeA, changeB};   
                }
            }
        }else{
            for(int i = 0; i<B.length; i++){
                int changeB = B[i];
                int changeA = changeB - difference;
                if(isExist(A,0,A.length-1,changeA)){
                    return new int[]{changeA, changeB};   
                }
            }
        }
        
        return new int[]{};
    }
    public boolean isExist(int[] array, int start, int end, int target){
        while(start <= end){
            int middle = (start + end) / 2;
            if(array[middle] == target){
                return true;
            }
            if(array[middle] < target){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return false;
    }
}