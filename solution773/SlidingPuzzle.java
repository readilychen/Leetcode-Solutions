import java.util.List;
import java.util.ArrayList;
class SlidingPuzzle{
    public int slidingPuzzle(int[][] board){
        int boardHeight = board.length;
        int boardWidth = board[0].length;
        int desti = 0;
        int destj = 0;
        for(int i =0;i<2;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == 0){
                    desti = i;
                    destj = j;
                }
            }
        }
        List<Integer> existlist = new ArrayList<Integer>();
        //Using DFS to search the path from source to the dest
        int sourceI = 1;
        int sourceJ = 2;
        //Add the first node to the existlist
        existlist.add(encodeIndex(sourceI,sourceJ));
        return DFS(0,sourceI,sourceJ,desti,destj,existlist,orginalBoard,board);
    }
    public int DFS(int count,int starti,int startj,int desti,int destj,List existlist,int[][] board,int [][]comparedboard){
        count++;
        int min = 5;
        boolean flag = false;
        Step[] steps= new Step[4];
        steps[0] = new Step(1,0);
        steps[1] = new Step(-1,0);
        steps[2] = new Step(0,1);
        steps[3] = new Step(0,-1);
        for(int i = 0;i<steps.length;i++){
            Step s = steps[i];
            int di = s.getI();
            int dj = s.getJ();
            if(di+starti == desti && dj+startj==destj){
                Step temp = steps[0];
                steps[0] = steps[i];
                steps[i] = temp;
            }
        }
        for(int i = 0;i<steps.length;i++){
            Step s = steps[i];
            int di = s.getI();
            int dj = s.getJ();
            if(di+starti == desti && dj+startj==destj){
                int[][] newBoard = swapper(starti,startj,desti,destj,board);
                System.out.println("newBoard:");
                for(int k = 0;k<2;k++){
                    for(int f = 0;f<3;f++){
                        System.out.print(" "+newBoard[k][f]);
                    }
                    System.out.println(" ");
                }
                System.out.println("Board:");
                for(int k = 0;k<2;k++){
                    for(int f = 0;f<3;f++){
                        System.out.print(" "+board[k][f]);
                    }
                    System.out.println(" ");
                }
                if(compareTwoArray(newBoard,comparedboard)){
                    return count;
                }
            }else{
                if(0<= di+starti && di+starti < 2 && 0<=dj+startj && dj+startj < 3 && !existlist.contains(encodeIndex(di+starti,dj+startj))){
                    int[][] newBoard = swapper(starti,startj,di+starti,dj+startj,board);
                    System.out.println("each step:");
                    for(int k = 0;k<2;k++){
                        for(int f = 0;f<3;f++){
                            System.out.print(" "+newBoard[k][f]);
                        }
                        System.out.println(" ");
                    }
                    existlist.add(encodeIndex(starti,startj));
                    System.out.println("starti: " +starti+di +"startj: "+startj+dj);
                    int result = DFS(count,starti+di,startj+dj,desti,destj,existlist,newBoard,comparedboard);
                    System.out.println("result:"+result);
                    if(result > 0 && result <= min ){
                        min = result;
                        flag = true;
                    }
                }
            }
        }
        if(flag){
            return min;
        }else{
            return 0;
        }
    }
    public boolean compareTwoArray(int[][] board1,int[][]board2){
     for(int i = 0 ;i<2;i++){
        for(int j = 0 ;j<3;j++){
            if(board1[i][j] != board2[i][j]){
                return false;
            }
        }
    }
    return true;
}

public int encodeIndex(int i, int j){
    return i*10+j;
}
public int[][] swapper(int sourcei,int sourcej,int targeti,int targetj,int[][]board){
    int [][]newBoard = new int[board.length][board[0].length];
    for(int i = 0;i<board.length;i++){
        for(int j = 0;j<board[0].length;j++){
            newBoard[i][j] = board[i][j];
        }
    }
    int temp = newBoard[sourcei][sourcej];
    newBoard[sourcei][sourcej]=newBoard[targeti][targetj];
    newBoard[targeti][targetj] = temp;
    return newBoard;
}
public static void main(String[] args) {
    int[][] board = {{4,1,2},{5,0,3}};
    SlidingPuzzle sp = new SlidingPuzzle();
    System.out.println(sp.slidingPuzzle(board));
    
}
}
class Step{
    int di;
    int dj;
    public int getI(){
        return di;
    }
    public int getJ(){
        return dj;
    }
    Step(int di,int dj){
        this.di = di;
        this.dj = dj;
    }
}