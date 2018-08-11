import java.util.ArrayList;
import java.util.List;
class solution779{
    public int kthGrammar(int N, int K) {
        List<Integer> branchList = getBranchList(N,K);
        int currentNode = 0;
        for(int i = branchList.size()-1;i>=0;i--){
            int direction = branchList.get(i);
            if(currentNode == 0){
                //turn to the right branch
                if(direction == 1){
                    currentNode = 1;
                }else{
                //turn to the left branch
                    currentNode = 0;
                }
            }else{
                if(direction == 1){
                    currentNode = 0;
                }else{
                    currentNode = 1;
                }
            }
        }
        return currentNode;
    }
    public List<Integer> getBranchList(int N,int K){
        //0 indicates go left, 1 indicates go right
        List<Integer> branchList = new ArrayList<>();
        while(N>0){
            N = N-1;
            int comparedNum = powersOfTwo(N);
            if(K > comparedNum){
                //turn to the right branch
                K = K - comparedNum;
                branchList.add(1);
            }else{
                //turn to the left branch
                branchList.add(0);
            }
        }
        return branchList;
    }
    public int powersOfTwo(int power){
        return 1 << power;
    }
    //This method is brute search which will casuse time limit error
    public String getResult(String s){
        String result = s.charAt(0) =='0'?"01":"10";
        for(int i=1 ;i<s.length();i++){
            if(s.charAt(i)=='0'){
                result = result + "01";
            }else{
                result = result + "10";
            }
        }
        return result;
    }
    //Recursively append the string will cause stackOverFlow
    public String recursivelyReplace(String s){
        if(s.length() == 1){
            if(s.charAt(0)=='0'){
                return "01";
            }else{
                return "10";
            }
        }else{
            if(s.charAt(0)=='0'){
                return "01"+recursivelyReplace(s.substring(1,s.length()));
            }else{
                return "10"+recursivelyReplace(s.substring(1,s.length()));
            }
        }
        
    }
    public static void main(String[] args) {
        solution779 s779 = new solution779();
        System.out.println(s779.kthGrammar(1,1));
        
    }
}