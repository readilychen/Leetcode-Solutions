import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


Class MST{
    Class Connection{
        String from;
        String to;
        int cost;
        public Connection(){

        }
        public Connection(String from, String to, int c){
            this.from = from;
            this.to = to;
            this.c = c;
        }
    }


    class SortbyCost implements Comparator<Connection> 
    { 
        // Used for sorting in ascending order of 
        // roll number 
        public int compare(Connection a, Connection b) 
        { 
            return a.cost - b.cost; 
        } 
    }
    public class Component{
        String parent;
    }
    public void union(String one, String two, int[] corrArray){
        int value = corrArray[two];
        int oneValue =corrArray[one];
        for(int i=0; i<corrArray; i++){
            if(corrArray[i] == oneValue){
                corrArray[i] = value;
            }
        }
    }
    public void find(String element, int[] corrArray){
        return corrArray[element];
    }
    public List<Connection> minimumCost(int n, List<Connection> inputList){

        Set<String> uniquePointSet = new HashSet<>();
        for(int i=0; i<inputList.size(); i++){
            Connection c = inputList.get(i);
            uniquePointSet.add(c.src);
            uniquePointSet.add(c.dest);
        }
        int numVertices = uniquePointSet.size();
        List<String> uniqueList = new ArrayList<>(uniquePointSet);
        Collections.sort(inputList, new SortbyCost());

        int index = 0;
        List<Connection> result = new ArrayList<Connection>();
        int[] corrArray = new int[numVertices];
    
        for(int i=0; i<corrArray.length; i++){
            corrArray[i] = i;
        }

        while(result.size() < numVertices-1){
            if(index >= inputList.size()){
                return new ArrayList<Connection>();
            }
            Connection e = inputList.get(index);
            String from = e.from;
            String to = e.to;

            int fromParent = find(from);
            int toParent = find(to);

            if(fromParent == toParent){
                continue;
            }
            result.add(e);
            index++;
            union(from, to);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Connection> inputList = new ArrayList<>();
        inputList.add(new Connection("A","B",1));
        inputList.add(new Connection("B","C",4));
        inputList.add(new Connection("A","C",5));
        MST mst = new MST();
        List<Connection> resultList = mst.minimumCost(3,inputList);
        for(Connection r  : resultList){
            System.out.println("from : "+r.from + " to: "+r.to);
        }

    }
}