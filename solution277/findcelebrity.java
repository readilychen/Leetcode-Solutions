/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
import java.util.Arrays;
public class findcelebrity {
    public int findCelebrity(int n,boolean[][] knows) {
        if(n == 0){
            return -1;
        }
        Integer[][] knowList = new Integer[n][n];
        
        for (Integer[] row: knowList){
            Arrays.fill(row, -1);
        }
            
        for(int i=0; i<n; i++){
            boolean knowOthers = false;
            for(int j = 0; j<n; j++){
                if(i!=j){
                   if(knowList[i][j]==-1){
                        if(knows[i][j]){
                            knowOthers = true;
                            knowList[i][j] = 1;
                        }else{
                            knowList[i][j] = 0;
                        }
                    }else{
                       if(knowList[i][j] == 1){
                           knowOthers = true;
                       }
                   }
                }
            }
            if(!knowOthers){
                boolean otherNotKnows = false;
                for(int k = 0; k<n; k++){
                    if(k != i){
                        if(knowList[k][i] == -1){
                            if(!knows[k][i]){
                                knowList[k][i] = 0;
                                otherNotKnows = true;
                            }else{
                                knowList[k][i] = 1;
                            }
                        }else{
                            if(knowList[k][i] == 0){
                                otherNotKnows = true;
                            }
                        }
                    }
                }
                if(!otherNotKnows){
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        findcelebrity s = new findcelebrity();
        boolean[][] knows = {{false,false,false},{true,false,false},{true,false,false}};
        System.out.println(s.findCelebrity(3,knows));
    }
}