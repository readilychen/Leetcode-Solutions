class Solution1{
    public boolean validTicTacToe(String[] board) {
        int numX = 0;
        int numO = 0;
        boolean oWin = false;
        boolean xWin = false;
        boolean diaSame = false;
        int numTogether = 0;
        for(int i=0;i<3;i++){
            String row = board[i];
            char rowFirst = board[i].charAt(0);
            boolean rowSame = true;
            boolean colSame = true;
            for(int j =0;j<3;j++){
                if(board[j].charAt(i)!=board[0].charAt(i) ||board[j].charAt(i)==' '){
                    colSame = false;
                }
                if(rowFirst != board[i].charAt(j) || rowFirst == ' '){
                    rowSame = false;
                }
                if(row.charAt(j) == 'X'){
                    numX++;
                }else if(row.charAt(j) == 'O'){
                    numO++;
                } 
            }
            if(rowSame){
                System.out.println("haha1");
                char winChar =board[i].charAt(0);
                if(winChar == 'O'){
                    oWin = true;
                }else if(winChar == 'X'){
                    xWin = true;
                }
                numTogether++;
            }
            if(colSame){
                System.out.println("haha2");
                char winChar =board[0].charAt(i);
                if(winChar == 'O'){
                    oWin = true;
                }else if(winChar == 'X'){
                    xWin = true;
                }
                numTogether++;
            }
        }
        if(board[1].charAt(1)!=' '&&board[0].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[2].charAt(2)){
            diaSame = true;
            System.out.println("haha3");
            numTogether ++;
        }
        if(board[1].charAt(1)!=' '&&board[2].charAt(0)==board[1].charAt(1)&&board[1].charAt(1)==board[0].charAt(2)){
            diaSame = true;
            System.out.println("haha4");
            numTogether ++;
        }
        if(diaSame){
            char winChar =board[1].charAt(1);
                if(winChar == 'O'){
                    oWin = true;
                }else if(winChar == 'X'){
                    xWin = true;
                }
          
        }
        if(numX - numO>=0&&numX-numO<=1){
            System.out.println(numTogether);
            if(numTogether > 1){
                return false;
            }else{
                if(oWin&&numO!=numX){
                    return false;
                }else if(xWin&&numX-numO!=1){
                    return false;
                }   
            }
        }else{
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] board = {"XOX","OXO","OXX"};
        Solution1 s1 = new Solution1();
        System.out.println(s1.validTicTacToe(board));
    }
}