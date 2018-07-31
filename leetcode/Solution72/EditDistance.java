class EditDistance{
    public int minDistance(String word1, String word2) {
        return minRecursively(word1,word2);
    }
    public int nonRecursively(String word1,String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            cost[i][0]=i; 
        }
        for(int j = 1;j<= n; j++){
            cost[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1];
                }else{
                    int a = cost[i-1][j] + 1;
                    int b = cost[i][j-1] + 1;
                    int c = cost[i-1][j-1] + 1;
                    int result = Math.min(Math.min(a,b),c);
                    cost[i][j] = result;
                }
            }
        }
        return cost[m][n];
    }
    public int minRecursively(String word1,String word2){
        char last1;
        char last2;
        if(!word1.equals("") && !word2.equals("")){
            last1 = word1.charAt(word1.length()-1);
            last2 = word2.charAt(word2.length()-1);
        }else{
            return word1.length() > word2.length() ? word1.length():word2.length();
        }
        int lastMin = minRecursively(word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
        if(last1==last2){
            return lastMin;
        }else{
            int method1 = lastMin+1;
            int method2 = minRecursively(word1.substring(0,word1.length()-1),word2)+1;
            int method3 = minRecursively(word1,word2.substring(0,word2.length()-1))+1;
            return getMin(method1,method2,method3);
        }
    }
    public int getMin(int a,int b,int c){
        int min = a < b?a:b;
        return min < c ? min : c;
    }
    public static void main(String[] args) {
        String word1 = "acbde";
        String word2 = "ac";
        EditDistance ed = new EditDistance();
        
        System.out.println(ed.minDistance(word1,word2));
        System.out.println(ed.nonRecursively(word1,word2));
    }
}