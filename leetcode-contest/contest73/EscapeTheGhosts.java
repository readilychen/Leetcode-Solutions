import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class EscapeTheGhosts{
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    public boolean escapeGhosts1(int[][] ghosts, int[] target) {
        for(int k =0;k<ghosts.length;k++){
            minX = minX < ghosts[k][0]? minX:ghosts[k][0];
            maxX = maxX > ghosts[k][0]? maxX:ghosts[k][0];

            minY = minY < ghosts[k][1]? minY:ghosts[k][1];
            maxY = maxY > ghosts[k][1]? maxY:ghosts[k][1];

        }
        System.out.println("minx "+minX);
        System.out.println("maxx "+maxX);
        System.out.println("miny "+minY);
        System.out.println("maxy "+maxY);
        
        int minghost = Integer.MAX_VALUE;
        for(int i = 0;i<ghosts.length;i++){
            int[][] ghost = new int[1][2];
            ghost[0][0] = ghosts[i][0];
            ghost[0][1] = ghosts[i][1];
            System.out.println("start form x : "+ ghost[0][0]);
            System.out.println("start from y : : "+ ghost[0][1]);

            int dis = disToTarget(ghost,target);
            System.out.println("ghost distance : "+dis);
            minghost = minghost < dis?minghost:dis;
        }
        int[][] start = new int[1][2];
        start[0][0] = 0;
        start[0][1] = 0;
        int distance = disToTarget(start,target);
        System.out.println("distance "+distance);
        return distance<minghost;
    }
    public boolean escapeGhosts(int[][] ghosts, int[] target){
        int mindis = Integer.MAX_VALUE;
        for(int i =0;i<ghosts.length;i++){
            int dis = eularDist(ghosts[i][0],ghosts[i][1],target[0],target[1]);
            mindis = mindis < dis?mindis:dis;
        }
        int agentDis = eularDist(0,0,target[0],target[1]);
        return agentDis<mindis;

    }
    public int eularDist(int startx, int starty, int endx, int endy){
        return Math.abs(startx-endx) + Math.abs(starty-endy);
    }
    public int disToTarget(int[][] ghost, int[] target){
        int x = ghost[0][0];
        int y = ghost[0][1];
        int tx = target[0];
        int ty = target[1];
        int[] dir = {1,0,-1,0,0,1,0,-1};
        List<myTuple> existList = new ArrayList<myTuple>();
        Queue<myTuple> bfsQueue = new LinkedList<myTuple>();
        bfsQueue.offer(new myTuple(x,y,0));
        while(!bfsQueue.isEmpty()){
            myTuple processT = bfsQueue.poll();
            existList.add(processT);
            System.out.println("processT x : " +processT.getX() + " y : "+processT.getY() );
            System.out.println("**********");
            for(int i=0;i<4;i++){
                int count = processT.getCount();
                int newX = processT.getX() + dir[i*2];
                int newY = processT.getY() + dir[i*2+1];
                myTuple addOne = new myTuple(newX,newY,count+1);
                if(!existList.contains(addOne) && newX >= minX && newY >= minY&& newX <= maxX && newY<=maxY){
                      System.out.println("newX : " + newX);
                      System.out.println("newY : " + newY);
                      bfsQueue.offer(addOne);
                }
            }
            if(processT.getX() == tx && processT.getY() == ty){
                return processT.getCount();
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); 
        int[][] ghosts = {{-10,-9},{5,0},{-7,-3},{-6,-1},{-4,-7}};
        int[] target = {7,-2};
        EscapeTheGhosts etg = new EscapeTheGhosts();
        System.out.println(etg.escapeGhosts(ghosts,target));
        long end = System.currentTimeMillis();
        System.out.println(" executing time "+ (end - start));

    }
}
class myTuple{
    int x;
    int y;
    int count;
    myTuple(int x,int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
    public int getCount(){
        return count;
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
        result = 31 * result + x ;
        result = 31 * result + y ;
        return result;
    }
}
