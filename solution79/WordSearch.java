import java.util.Character;
import java.util.Queue;
class WordSearch{

    // BFS solution
    public boolean exist1(char[][] board, String word) {
        if(word == null || word == ""){
            return false;
        }
        char[][] visited = new char[board.length][board[0].length];
        int[] direction = {0,1,0,-1,1,0,-1,0};
        Queue<Integer[]> q = new ArrayList<>();
        Queue<Integer[]> q2 = new ArrayList<>();
        int currentWord = 0;
        char firstChar = word.charAt(currentWord);
        currentWord++;
        for(int i=0; i<board.length; i++){
            for(int j=0; board[0].length; j++){
                if(board[i][j] == firstChar){
                    Integer[] target = {i,j};
                    q.offer(target);
                    visited[i][j] = 1;
                }
            }
        }
        while(q.size() > 0){
            while(q.size() > 0){
                char targetChar = word.charAt(currentWord);
                Integer[] tempValue = q.poll();
                for(int i =0; i<4; i++){
                    int imove = direction[i];
                    int jmove = direction[2*i];
                    if(imove+tempValue[0] <= board.length && imove+tempValue[0] >= 0
                        && jmove + tempValue[1] <= board.length && jmove + tempValue[1] >=0 ){
                        if(board[imove+tempValue[0]][jmove+tempValue[1]] == targetChar 
                            && visited[imove+tempValue[0]][jmove+tempValue[1]] == 0){
                            q2.offer(new Integer[]{imove+tempValue[0],jmove+tempValue[1]});
                        }
                    }
                }
            }
            currentWord++;
            if(currentWord == word.length){
                return true;
            }else{
                if(q2.size()==0){
                    return false;
                }   
            }
            q=q2;
            q2 = new ArrayList<>();
        }
        return false;
    }
    public static void main(String[] args){


    }
}