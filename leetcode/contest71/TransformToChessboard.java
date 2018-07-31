import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.ArrayList;
class TransformToChessboard{
    public boolean movesToChessboard(int[][] board) {
        int numBoard = board.length;
        int[][] targetBoard1 =new int[numBoard][numBoard];
        int[][] targetBoard2 = new int [numBoard][numBoard];
        boolean t1Start = true;
        boolean t2Start = false;
        char[] chars = new char[numBoard];
        for(int i = 0;i<numBoard;i++){
            char index = (char)(65+i);
            chars[i] = index;
            t1Start = t1Start?false:true;
            t2Start = t2Start?false:true;
            for(int j =0;j<numBoard;j++){
                targetBoard1[i][j] = t2Start?0:1;
                targetBoard2[i][j] =  t1Start?0:1;
                t1Start = t1Start?false:true;
                t2Start = t2Start?false:true;
            }
        }

        String S = String.valueOf(chars); 
        List<String> resultList = fullArrangement(S);
        int count = 0;
        for(String str : resultList){
            
            int[][] newBoard = new int[numBoard][numBoard];
            for(int i=0;i<str.length();i++){
                char charIndex = str.charAt(i);
                int myIndex = charIndex - 'A';
                for(int j = 0;j<numBoard;j++){
                    newBoard[i][j] = board[myIndex][j];
                }
            } 
            for(String instr : resultList){
                count++;
                int [][] newBoard1 = new int[numBoard][numBoard];
                for(int k = 0 ;k<numBoard;k++){
                    char charIndex1 = instr.charAt(k);
                    int myIndex1 = charIndex1 - 'A';
                    //System.out.println(myIndex1);
                    for(int l = 0 ;l<numBoard;l++){
                        newBoard1[l][k] = newBoard[l][myIndex1];
                    }
                }

                // for(int i=0;i<numBoard;i++){
                //     for(int j =0;j<numBoard;j++){
                //         System.out.print(newBoard1[i][j]+ " ");
                //     }
                //     System.out.println(" ");
                // }
                // System.out.println("*****************************************");
                if(canTransform(newBoard1,targetBoard1)||canTransform(newBoard1,targetBoard2)){
                    return true;
                }
            }

        }
        System.out.println("count "+count);
        return false;
    }
    public boolean canTransform(int[][]board,int[][] newBoard){
        for(int i =0;i<newBoard.length;i++){
            for(int j=0;j<newBoard.length;j++){
                if(board[i][j]!=newBoard[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public List<String> fullArrangement(String S){
        List<String> resultList = new ArrayList<String>();
        if(S.length() == 1){
            resultList.add(S);
            return resultList;
        }else{
           for(int i =0;i< S.length();i++){
            String start = String.valueOf(S.charAt(i));
                //System.out.println("start"+start);
            List<String> nextList = fullArrangement(S.substring(0,i)+S.substring(i+1,S.length()));
            for(String end: nextList ){
                resultList.add(start + end );
            }
        }
    }
        return resultList;
}

public static void main(String[] args) {
    long startTime = System.currentTimeMillis(); 
    int[][] board =  {{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
    TransformToChessboard ttc = new TransformToChessboard();

    System.out.println(ttc.movesToChessboard(board));
    long endTime = System.currentTimeMillis(); 
    System.out.println("Execute time: "+ (endTime- startTime));
}
}