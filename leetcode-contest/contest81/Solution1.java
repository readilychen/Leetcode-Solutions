import java.util.ArrayList;
class Solution1{
    public int[] shortestToChar(String S, char C) {
        int lastIndex = -1;
        int[] shortestDist = new int[S.length()];
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == C){
                //System.out.println("i "+i);
                if(lastIndex < 0){
                    int dis = 0;
                    for(int j = i;j>=0;j--){
                        shortestDist[j] = dis;
                        dis++;
                    }
                }else{
                    
                    if((i-lastIndex-1) == 0){
                        shortestDist[i] = 0; 
                        lastIndex = i;                     
                        continue;
                    }
                    if((i-lastIndex-1) == 1){
                        shortestDist[i-1]=1;
                        lastIndex = i;
                        continue;
                    }
                    int dis = 0;
                    for(int j = 0 ; j<= (i-lastIndex-1)/2;j++){
                        // System.out.println("lastIndex+j "+(lastIndex+j) +" i "+ dis);
                        // System.out.println("i-j         "+(i-j) +" i "+ dis);

                        shortestDist[lastIndex+j] = dis;
                        shortestDist[i - j]=dis;
                        dis++;
                    }

                    if((i-lastIndex-1)%2 != 0){   
                        shortestDist[lastIndex + (i-lastIndex-1)/2 + 1 ]=dis;
                    }
                }
                lastIndex = i;
            }
        }
        if(lastIndex != S.length()){
            int dis = 0;
            for(int i = lastIndex;i<S.length();i++){
                shortestDist[i] = dis;
                dis++;
            }
        }
        return shortestDist;
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        String S = "cizokxcijwbyspcfcqws";
        char C = 'c';
        int[] shortestDist = s1.shortestToChar(S,C);
        for(int i =0;i<shortestDist.length;i++){
            System.out.print(shortestDist[i] + " , ");
        }
    }
}
