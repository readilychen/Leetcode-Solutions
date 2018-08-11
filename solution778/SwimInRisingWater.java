import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class SwimInRisingWater{
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int startV = grid[0][0] > grid[N-1][N-1]?grid[0][0]:grid[N-1][N-1];
        return binarySearchMaxCost(grid,startV,N*N-1);
    }
    public int binarySearchMaxCost(int[][] grid,int leftPoint,int rightPoint){
        if(rightPoint - leftPoint <= 1){
            return leftPoint;
        }
        int middlePoint =0;
        while(rightPoint-leftPoint != 1){
            middlePoint = (rightPoint + leftPoint) >> 1;
            if(checkRouteAccess(grid,middlePoint)){
                rightPoint = middlePoint ;
            }else{
                leftPoint = middlePoint ;
            }
        }
        if(checkRouteAccess(grid,leftPoint)){
            return leftPoint;
        }else{
            return rightPoint;
        }
    }
    //Using dfs to search whether the Route can access to the final result.
    public boolean checkRouteAccess(int [][]grid,int value){
        int []direction= {0,1,0,-1,1,0,-1,0};
        //Strat from grid[0][0];
        List<myTuple> existList = new ArrayList<>();
        Queue<myTuple> queue = new LinkedList<>();
        myTuple firstElem = new myTuple(0,0);
        queue.offer(firstElem);
        existList.add(firstElem);
        int N = grid.length;
        int k = 0;
        while(!queue.isEmpty()){
            //get One element fromt the queue
            myTuple element = queue.poll();

            if(element.getX() == N-1  && element.getY() == N-1 ){
                return true;
            }
            int x = element.getX();
            int y = element.getY();
            System.out.println("element x : " + element.getX()+"element y : "+element.getY());
            for(int i =0;i<4;i++){
                int nx = x + direction[2*i];
                int ny = y + direction[2*i+1];
                myTuple surround = new myTuple(nx,ny);
                if(nx < 0 || nx >= N  || ny < 0 || ny >=N || grid[nx][ny] > value ||existList.contains(surround) ){
                    continue;
                }else{
                    System.out.println(" x "+surround.getX()+" y "+surround.getY());
                    queue.offer(surround);
                    existList.add(surround);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SwimInRisingWater srw = new SwimInRisingWater();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int[][] grid1 = {{0,3},{1,2}};
        int[][] grid4 = {{11,15,3,2},{6,4,0,13},{5,8,9,10},{1,14,12,7}};
        int[][] grid3 = {{0,2},{1,3}};
        int[][] grid2 = {{7,23,21,9,5},{3,20,8,18,15},{14,13,1,0,22},{2,10,24,17,12},{6,16,19,4,11}};
        //System.out.println(srw.checkRouteAccess(grid2,15));
        System.out.println(srw.swimInWater(grid4));

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
