import java.util.List;
import java.util.ArrayList;
class Solution2{
    int finalNode = 0;
    //List<List<Integer>> finalResultList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        finalNode = graph.length-1;
        List<Integer> initial = new ArrayList<>();
        List<List<Integer>> finalResultList = new ArrayList<>();
        initial.add(0);
        findPath(graph,0,initial,finalResultList);
        return finalResultList; 
    }
    public void findPath(int[][] graph,int startPoint,List<Integer> resultList,List<List<Integer>> finalResultList){
        if(startPoint == finalNode){
            finalResultList.add(new ArrayList(resultList));
            System.out.println(resultList);
        }
        int[] allPossibleNode = graph[startPoint];
        //System.out.println("startPoint " + startPoint);
        for(int i =0;i<allPossibleNode.length;i++){
            if(allPossibleNode[i] > startPoint){
                resultList.add(allPossibleNode[i]);
                findPath(graph,allPossibleNode[i],resultList,finalResultList);
                resultList.remove(resultList.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> myfinal= s2.allPathsSourceTarget(graph);
        for(List<Integer> list : myfinal){
            for(Integer myi : list){
                System.out.print(myi + " -> ");
            }
            System.out.println();
        }
    }
}