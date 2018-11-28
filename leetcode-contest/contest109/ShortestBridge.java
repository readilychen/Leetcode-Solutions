class ShortestBridge {
    int[] steps = {0,1,0,-1,1,0,-1,0};
    List<List<Integer>> tempList = new ArrayList<>();
    public int shortestBridge(int[][] A) {
        Queue<Integer> tempQueue = new LinkedList<>();
        int[][] newA = new int[A.length][A[0].length];
        int[][] visited = new int[A.length][A[0].length];
        int count = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){ 
                if(visited[i][j] == 0 && A[i][j] == 1){
                    visited[i][j] = 1;
                    count++;
                    A[i][j] = count;
                    List<Integer> list = new ArrayList<>();
                    list.add(i*A[0].length + j);
                    dfs(i,j,visited,A,count,list);
                    tempList.add(list);
                }
            }
        }
        List<Integer> group1 = tempList.get(0);
        List<Integer> group2 = tempList.get(1);
        boolean flag = false;
        if(group1.size() > group2.size()){
            flag = true;
        }
        int minValue = Integer.MAX_VALUE;
        
        //System.out.println(newVisited.length);
        if(flag){
            for(Integer start: group2){
                int[] newVisited = new int[A.length * A[0].length];
                int tempMin = bfsFindMin(start, 1 ,newVisited, A , A[0].length, A.length);
                if(tempMin == 1){
                    return 1;
                }
                minValue = minValue > tempMin ? tempMin : minValue;
            }
        }else{
            for(Integer start: group1){
                int[] newVisited = new int[A.length * A[0].length];
                int tempMin = bfsFindMin(start, 2, newVisited, A, A[0].length, A.length);
                if(tempMin == 1){
                    return 1;
                }
                minValue = minValue > tempMin ? tempMin : minValue;
            }
        }
        
        return minValue;
    }
    public int bfsFindMin(int startPoint, int target, int[] visited, int[][] A, int colWidth, int rowHeight){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(startPoint);
        visited[startPoint] = 1;
        int count = 0;
        while(q1.size() > 0){
            while(q1.size() > 0){
                Integer value = q1.poll();
                
                int starti = value / colWidth;
                int startj = value % colWidth;
                for(int i=0; i<4; i++){
                    int changei = starti + steps[2*i];
                    int changej = startj + steps[2*i+1];
                    //System.out.println(changei * colWidth + changej);
                    if(changei >= 0 && changei < rowHeight && changej >= 0 && changej < colWidth && visited[changei * colWidth + changej] == 0 ){
                        if(A[changei][changej] == target){
                            return count;
                        }else if(A[changei][changej] == 0){
                            q2.offer(changei * colWidth + changej);
                        }
                        visited[changei * colWidth + changej] = 1;
                    }
                }
            }
            count++;
            q1 = q2;
            q2 = new LinkedList<Integer>();
            
        }
        return Integer.MAX_VALUE;
    }
    public void dfs(int starti, int startj, int[][] visited, int[][] A, int count, List<Integer> tempList){
        for(int i=0; i<4; i++){
            int changei = starti + steps[2 * i];
            int changej = startj + steps[2 * i + 1];
            if(changei >= 0 && changei < visited.length && changej >= 0 
               && changej < visited[0].length && visited[changei][changej] == 0 && A[changei][changej] == 1){
                A[changei][changej] = count;
                visited[changei][changej] = 1;
                tempList.add(changei * A[0].length + changej);
                dfs(changei,changej,visited,A,count,tempList);
            }
        }
    }
}