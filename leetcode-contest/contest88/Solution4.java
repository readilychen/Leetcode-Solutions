import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution4 {
    //BFS to solve this problem
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int[][] distance = new int[1<<N][N];
        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Queue<State> stateQueue = new LinkedList<>();
        //initialize the distance matrix
        for(int i = 0; i<N ; i++){
            distance[1<<i][i] = 0;
            stateQueue.offer(new State(1<<i,i));
        }
        while(!stateQueue.isEmpty()){
            State processedState = stateQueue.poll();
            int cover = processedState.cover;
            int currentNode = processedState.currentNode;
            for(int node : graph[currentNode]){
                int cover1 = (cover | 1 << node);
                if(cover1 == ((1 << N) - 1)){
                    return distance[cover][currentNode] + 1;
                }else{
                    int d = distance[cover][currentNode];
                    if (distance[cover1][node] > d + 1){
                        distance[cover1][node] = d + 1;
                        stateQueue.offer(new State(cover1,node));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution4 s4 = new Solution4();
        //int[][] graph = {{1,2,3},{0},{0},{0}};
        int[][] graph2 = {{2,3,5,7},{2,3,7},{0,1},{0,1},{7},{0},{10},{9,10,0,1,4},{9},{7,8},{7,6}};
        //System.out.println(s4.shortestPathLength(graph));
        System.out.println(s4.shortestPathLength(graph2));
    }
}
class State{
    public int cover;
    public int currentNode;
    public State(int cover, int currentNode){
        this.cover = cover;
        this.currentNode = currentNode;
    }
}