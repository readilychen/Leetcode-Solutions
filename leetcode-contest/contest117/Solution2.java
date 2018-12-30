class Solution2 {
    List<String> strList = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        
        for(int i=1; i<=9; i++){
            String startStr = String.valueOf(i);
            addToList(startStr, N-1, K);
        }
        if(N == 1){
            strList.add("0");
        }
        
        int[] result = new int[strList.size()];
        for(int i=0; i<strList.size(); i++){
            result[i] = Integer.valueOf(strList.get(i));
        }
        return result;
    }
    public void addToList(String temp, int N, int K){
        
        if(N == 0){
            
            strList.add(temp);
            return;
        }
        
        Integer beforeValue = Integer.valueOf(temp.charAt(temp.length()-1) - '0');
        if(K == 0){
            String newTemp = temp + String.valueOf(beforeValue);
            addToList(newTemp, N-1, K);
        }else{
            if(beforeValue - K >= 0){
                int addValue = beforeValue - K;
                String newTemp = temp + String.valueOf(addValue);
                addToList(newTemp, N-1, K);
            }
        
        if(beforeValue + K <= 9){
                int addValue = beforeValue + K;
                String newTemp = temp + String.valueOf(addValue);
                addToList(newTemp, N-1, K);
            }
        }
        
    }
}