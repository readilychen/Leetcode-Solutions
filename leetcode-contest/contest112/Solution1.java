class Solution {
    // 1 ,2, 2
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        
        Map<Integer, Integer> indexMap = new TreeMap<>();
        for(int i=0; i<A.length; i++){
            if(indexMap.containsKey(A[i])){
                int count = indexMap.get(A[i]);
                indexMap.put(A[i],count+1);
            }else{
                indexMap.put(A[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> tempList = new ArrayList<>(indexMap.entrySet());
        Map.Entry<Integer,Integer> before = tempList.get(0);
        System.out.println(indexMap);
        int beforeCount = before.getValue();
        int beforeVal = before.getKey();
        int totalCount = 0;
        for(int i=1; i<tempList.size(); i++){
            Map.Entry<Integer,Integer> after = tempList.get(i);
            int afterCount = after.getValue();
            int afterVal = after.getKey();
            if(beforeCount == 1){
                before = after;
                beforeCount = afterCount;
                beforeVal = afterVal;
            }else{
                if((afterVal - beforeVal - 1) < (beforeCount - 1)){
                    for(int j=1; j<=afterVal - beforeVal - 1; j++){
                        totalCount += j;
                    }
                    int largerCount = (beforeCount - 1) - (afterVal - beforeVal - 1);
                    totalCount += largerCount * (afterVal - beforeVal );
                    before = after;
                    beforeCount = afterCount + largerCount;
                    beforeVal = afterVal;
                    //System.out.println(totalCount);
                }else{
                    for(int j=1; j<=beforeCount - 1; j++){
                        totalCount += j;
                    }
                    before = after;
                    beforeCount = afterCount;
                    beforeVal = afterVal;
                }
            }
        }
        //System.out.println(beforeCount);
        for(int i=0; i<beforeCount-1; i++){
            totalCount += (i+1);
        }
        return totalCount;
    }
}