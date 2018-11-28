class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int currentSum = 0;
        int result = 0;ß
        tempMap.put(0,1);
        for(int i=0; i<A.length; i++){
            currentSum += A[i];
            if(S > currentSum){
                int tempValue = tempMap.getOrDefault(currentSum, 0);
                tempMap.put(currentSum,tempValue+1);
            }else{
                int target = currentSum - S;
                int tempRes = 0;
                if(tempMap.containsKey(target)){
                    tempRes = tempMap.get(target);
                }
                result += tempRes;
                //System.out.println(tempRes);
                int tempValue = tempMap.getOrDefault(currentSum, 0);
                tempMap.put(currentSum,tempValue+1);
            }
        }
        //System.out.println(tempMap);
        return result;
    }
}