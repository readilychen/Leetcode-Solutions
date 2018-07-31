import java.util.HashSet;
class Solution2{
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> sameSet = new HashSet<Integer>();
        for(int i =0;i<fronts.length;i++){
            if(fronts[i]<backs[i]){
                int temp = fronts[i];
                fronts[i] = backs[i];
                backs[i] = temp;
            }else if(fronts[i] == backs[i]){
                sameSet.add(fronts[i]);
            }
        }
        sort(backs,fronts);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0;i<backs.length ;i++ ) {
            if(!sameSet.contains(backs[i])){
                smallest = backs[i] > smallest?smallest:backs[i];
                break;
            }
        }
        sort(fronts,backs);
        for (int i = 0;i<fronts.length ;i++ ) {
            if(!sameSet.contains(fronts[i])){
                smallest = fronts[i]>smallest?smallest:fronts[i];
                break;
            }
        }
        return smallest;
    }
    public void sort(int[] G,int [] G2){
        quickSort(0,G.length-1,G,G2);
    }
    public void quickSort(int start,int end, int[] G,int[] G2){
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
                    swap(G2,i,j);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(G[i]>G[j]){
                    swap(G,i,j);
                    swap(G2,i,j);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        quickSort(start,i-1,G,G2);
        quickSort(i+1,end,G,G2);
        return;
    }
    public void swap(int[] G, int i, int j){
        int temp = G[i];
        G[i] = G[j];
        G[j] = temp; 
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[] fronts = {1,1};
        int[] backs = {1,2};
        System.out.println(s2.flipgame(fronts,backs));
        
    }
}