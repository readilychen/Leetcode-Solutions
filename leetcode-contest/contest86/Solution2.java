import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution2{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> existRoom = new ArrayList<>();
        Stack<Integer> roomStack=new Stack<>();
        List<Integer> initRoom = rooms.get(0);
        existRoom.add(0);
        for(Integer key : initRoom){
            roomStack.push(key);
        }
        // DFS first search
        while(!roomStack.empty()){
            int tryKey = roomStack.pop();
            //System.out.println("tryket "+ tryKey);
            if (!existRoom.contains(tryKey)){
                existRoom.add(tryKey);
                List<Integer> nextRoom = rooms.get(tryKey);
                for(Integer key : nextRoom){
                    roomStack.push(key);
                }
            }
        }

        if(existRoom.size() == rooms.size()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);


        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);
        List<Integer> room3 = new ArrayList<>();
        room3.add(2);
        List<Integer> room4 = new ArrayList<>();
        room4.add(0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        System.out.println(s2.canVisitAllRooms(rooms));

        
    }
}