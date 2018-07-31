class Solution2{
    public void sort(int[] G,String [] G2,String[] G3){
        quickSort(0,G.length-1,G,G2,G3);
    }
    public void quickSort(int start,int end, int[] G,String[] G2,String[] G3){
        if(start > end){
            return;
        }
        boolean flag = true;
        //The key value to compared with
        int value = G[start];
        int i = start;
        int j = end;
        while(i!=j){
            if(flag){
                if(G[i]>G[j]){
                    swap(G,i,j);
                    swap1(G2,i,j);
                    swap1(G3,i,j);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(G[i]>G[j]){
                    swap(G,i,j);
                    swap1(G2,i,j);
                    swap1(G3,i,j);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        quickSort(start,i-1,G,G2,G3);
        quickSort(i+1,end,G,G2,G3);
        return;
    }
    public void swap1(String[] G,int i,int j){
        String temp = G[i];
        G[i] = G[j];
        G[j] = temp;
    }
    public void swap(int[] G, int i, int j){
        int temp = G[i];
        G[i] = G[j];
        G[j] = temp; 
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        sort(indexes,sources,targets);
        String finalString=new String(S);
        int difference = 0;
        for(int i = 0;i<indexes.length;i++){
            String replacedWord = sources[i];
            boolean canReplace = true;
            for(int j =0;j<replacedWord.length();j++){
                if(indexes[i]+j>S.length()-1||!(S.charAt(indexes[i]+j)==replacedWord.charAt(j))){
                    canReplace = false;
                    break;
                }
            }
            if(canReplace){
                
                String Sbefore="";
                String Safter = "";
                if(indexes[i] != 0){
                    Sbefore = finalString.substring(0,indexes[i]+difference);
                }
                
                if((indexes[i]+replacedWord.length())<S.length()){
                    System.out.println("hahah");
                    Safter=finalString.substring(indexes[i]+difference+replacedWord.length(),S.length()+difference);
                }
                System.out.println(indexes[i]+replacedWord.length());
                System.out.println(" 0 - "+(indexes[i]+difference));
                System.out.println((indexes[i]+difference+1) +" - "+(S.length()+difference));
        
                finalString = Sbefore + targets[i] + Safter;
                System.out.println(finalString);
                int targetLength = targets[i].length();
                int sourcesLength = replacedWord.length();
                difference += targetLength-sourcesLength;
                System.out.println("difference "+difference);
            }
        }
        return finalString;
    }
    public static void main(String[] args) {
        String S = "vmokgggqzp";
        int[] indexes = {3,5,1};
        String[] sources = {"kg","ggq","mo"};
        String[] targets = {"s","so","bfr"};
        Solution2 s2 = new Solution2();
        String result = s2.findReplaceString(S,indexes,sources,targets);
        System.out.println(result);
    }
}