class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
//         if(tokens.length == 0){
//             return 0;
//         }
        
//         int[] visited = new int[tokens.length];
//         int[][] cache = new int[tokens.length][2];
//         int maxValue = Integer.MIN_VALUE;
        
//         for(int i=0; i<tokens.length; i++){
//             visited[i] = 1;
//             if(P >= tokens[i]){
               
//                 int startValue = maxValue(tokens,visited,P-tokens[i],1,1);
//                 maxValue = maxValue > startValue ? maxValue : startValue;
//             }
//             visited[i] = 0;
//         }
//         return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
        Arrays.sort(tokens);
        int maxValue = Integer.MIN_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<tokens.length; i++){
            dq.offerLast(tokens[i]);
        }
        //System.out.println(dq);
        int point = 0;
        boolean flag = false;
        while(dq.size() > 0){
            
            if(P >= dq.peekFirst()){
                int element = dq.pollFirst();
                P = P - element;
                point+=1;
                maxValue = maxValue > point ? maxValue : point;
            }else{
                if(point < 1 ){
                    break;
                }
                P += dq.pollLast();
                point -= 1;
            }
        }
        return maxValue == Integer.MIN_VALUE? 0: maxValue;
    }
    
    public int maxValue(int[] tokens, int[] visited, int P, int point, int count){
        
        if(count == tokens.length){
            return point;
        }
        
//      System.out.println("P "+P);
//      System.out.println("point " + point);
//      System.out.println("count " + count);
        
        int maxValue = point;
        for(int i=0; i<tokens.length; i++){
            //System.out.println("i "+i);
            if(visited[i] == 0){
                visited[i] = 1;
                if(P >= tokens[i]){
                    int tempValue = maxValue(tokens,visited,P-tokens[i],point+1,count+1);
                    maxValue = maxValue > tempValue ? maxValue : tempValue;
                } 
                if(point >= 1){
                    int tempValue = maxValue(tokens,visited,P+tokens[i],point-1,count+1);
                    //System.out.println("temp2 "+tempValue);
                    maxValue = maxValue > tempValue ? maxValue : tempValue;
                }
                visited[i] = 0;
            }
        }
        return maxValue;
    }
}