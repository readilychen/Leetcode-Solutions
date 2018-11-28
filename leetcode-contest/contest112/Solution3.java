class Solution {
    public int removeStones(int[][] stones) {
        int[] visited = new int[stones.length];
        int max =0;
        Set<Integer> tempSet = new HashSet<>();
        for(int i=0; i<stones.length; i++){
            if(tempSet.contains(i)){
                continue;
            }
            int tempValue = dfs(visited, stones, i ,tempSet);
            max += tempValue;
        }
        return max;
    }
    public int dfs(int[] visited, int[][] stones, int startIndex, Set<Integer> visitedSet){
        visited[startIndex] = 1;
        visitedSet.add(startIndex);
        int startRow = stones[startIndex][0];
        int startCol = stones[startIndex][1];
        int maxRemove = Integer.MIN_VALUE;
        int rx = 0;
        int ry = 0;
        for(int i=0; i<stones.length; i++){
            if(visitedSet.contains(i)){
                continue;
            }
            if(visited[i] == 0){
                if(startRow == stones[i][0]){
                    rx = dfs(visited,stones,i,visitedSet)+1;
                }
                if(startCol == stones[i][1]){
                    ry = dfs(visited,stones,i,visitedSet)+1;
                }
            }
        }
        visited[startIndex] = 0;
        return rx + ry;
    }
}