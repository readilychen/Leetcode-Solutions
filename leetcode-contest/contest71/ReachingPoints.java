import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
class ReachingPoints{
    boolean flag = false;
    //DFS to search the point
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //findTransformRecursively(sx,sy,tx,ty);
        //dfsStackImpl(sx,sy,tx,ty);
        bfsQueueImpl(sx,sy,tx,ty);
        return flag;
    }
    public void dfsStackImpl(int sx, int sy, int tx, int ty){
        Stack<myTuple> dfsStack = new Stack<myTuple>();
        dfsStack.push(new myTuple(sx,sy));
        while(!dfsStack.isEmpty()){  
            myTuple processOne = dfsStack.pop();
            int px = processOne.getX();
            int py = processOne.getY();
            if(px == tx && py == ty){
                flag = true;
                break;
            }
            if(px > tx || py > ty ){
                continue;
            }
            dfsStack.push(new myTuple(px+py,py));
            dfsStack.push(new myTuple(px,px+py));
        }
    }
    public void bfsQueueImpl(int sx, int sy, int tx, int ty){
        Queue<myTuple> bfsQueue = new LinkedList<myTuple>();
        bfsQueue.offer(new myTuple(sx,sy));
        while(!bfsQueue.isEmpty()){
            myTuple processOne = bfsQueue.poll();
            int px = processOne.getX();
            int py = processOne.getY();
            if(px == tx && py == ty){
                flag = true;
                break;
            }
            if(px > tx || py > ty ){
                continue;
            }
            bfsQueue.offer(new myTuple(px+py,py));
            bfsQueue.offer(new myTuple(px,px+py));
        }
    }
    //Will cause stack overflow
    public void findTransformRecursively(int sx,int sy,int tx,int ty){
        if(sx > tx || sy > ty){
            return;
        }
        if(sx == tx && sy == ty){
            flag = true;
        }
        findTransformRecursively(sx+sy,sy,tx,ty);
        findTransformRecursively(sx,sx+sy,tx,ty);
    }
    public static void main(String[] args) {
        ReachingPoints rp = new ReachingPoints();
        System.out.println(rp.reachingPoints());
    }
}
class myTuple{
    int x;
    int y;
    myTuple(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof myTuple)){
            return false;
        }
        myTuple m = (myTuple) o;
        return m.x == x && m.y == y;
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}
