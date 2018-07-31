import java.util.Map;
import java.util.HashMap;
class SlidingPuzzle1{
    int []step = { 1,0,0,1,-1,0,0,-1};
    Map<Integer,Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    public int slidingPuzzle(int[][] board){
        //Find the start point
        int desti = 0;
        int destj = 0;
        for(int i =0;i<2;i++){
            for(int j=0;j<3;j++){
                if(board[i][j] == 0){
                    desti = i;
                    destj = j;
                    break;
                }
            }
        }
        map.put(123450,0);
        DFS(board,desti,destj,0);
        return min == Integer.MAX_VALUE ? -1:min;
    }
    public void DFS(int [][]board,int starti,int startj,int count){
        //Stop at the value where it's already reach the min
        if(count > min){
            return;
        }
        int encode = encode(board);
        if(encode == 123450){
            min = count;
            return;
        }
        if(map.containsKey(encode)){
            if(count > map.get(encode)){
                return;
            }
        }
        map.put(encode(board),count);
        for(int i=0;i<4;i++){
            int ni = starti + step[2*i];
            int nj = startj + step[2*i+1];
            if( ni >= 0 && ni < 2 && nj >= 0 && nj < 3){
              int [][]newBoard = swapper(starti,startj,ni,nj,board);
              DFS(newBoard,ni,nj,count+1);
            }
        }
    }
    public int[][] swapper(int sourcei,int sourcej,int targeti,int targetj,int[][]board){
        int [][]newBoard = new int[2][3];
        for(int i = 0;i<2;i++){
            for(int j = 0;j<3;j++){
                newBoard[i][j] = board[i][j];
            }
        }
        int temp = newBoard[sourcei][sourcej];
        newBoard[sourcei][sourcej]=newBoard[targeti][targetj];
        newBoard[targeti][targetj] = temp;
        return newBoard;
    }
    public int encode(int [][]board){
        int code = 0;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                code *=10;
                code +=board[i][j];
            }
        }
        return code;
    }
    public static void main(String[] args) {
         int[][] board = {{1,2,3},{5,4,0}};
         SlidingPuzzle1 sp = new SlidingPuzzle1();
         System.out.println(sp.slidingPuzzle(board));
        
    }
}