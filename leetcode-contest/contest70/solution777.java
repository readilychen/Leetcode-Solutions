import java.util.*;  
class solution777{
    public boolean canTransform(String start, String end) {
        List<myTuple> startList = new ArrayList<>();
        List<myTuple> endList = new ArrayList<>();
        for(int i =0;i<start.length();i++){
            if(start.charAt(i) == 'R'){
                startList.add(new myTuple(i,'R'));
            }else if(start.charAt(i) == 'L'){
                startList.add(new myTuple(i,'L'));
            }
            if(end.charAt(i) == 'R'){
                endList.add(new myTuple(i,'R'));
            }else if(end.charAt(i) == 'L'){
                endList.add(new myTuple(i,'L'));
            }
        }
        if(startList.size()!=endList.size()){
            return false;
        }
        for(int j = 0;j<startList.size();j++){

            myTuple tStart = startList.get(j);
            myTuple tEnd = endList.get(j);
            if(tStart.getCharacter()!=tEnd.getCharacter()){
                return false;
            }
            if(tStart.getCharacter() == 'R' && tStart.getPosition() > tEnd.getPosition()){
                return false;
            }
            if(tStart.getCharacter() == 'L' && tStart.getPosition() < tEnd.getPosition()){
                return false;
            }
        }   
        return true;   
    }
    public static void main(String[] args) {
        solution777 s777 = new solution777();
        System.out.println(s777.canTransform("RL","LR"));
    }
}
class myTuple{
    int position;
    char character;
    myTuple(int p,char c){
        position = p;
        character = c;
    }
    public int getPosition(){
        return this.position;
    }
    public char getCharacter(){
        return this.character;
    }
}