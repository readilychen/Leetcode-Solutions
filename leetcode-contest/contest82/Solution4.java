import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Arrays;
class Solution4{
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0;
        int[] workerBest = new int[worker.length];
        sort(difficulty,profit);
        Arrays.sort(worker);
        boolean assign = false;
        //init the first element in worker best
        int j =0;
        int k = 0;
        int maxProfit = Integer.MIN_VALUE;
        for(;j<difficulty.length;j++){
            if(k==worker.length){
                return 0;
            }
            if(difficulty[j]>worker[k]){
                //if the first element is larger than worker[k]
                if(j == 0){
                    workerBest[k] = 0;
                    k++;
                    //compare the seconde worker
                    j--;
                }else{
                    assign = true;
                    totalProfit += maxProfit;
                    workerBest[k] = maxProfit;
                    k++;
                    break;
                }
            }else{
                 maxProfit = maxProfit>profit[j]?maxProfit:profit[j];
            }
        }
        if(!assign){
            return totalProfit+maxProfit*(workerBest.length-k);
        }
        System.out.println("maxProfit "+maxProfit+" , j "+j+" , k "+ k);
        
        for(;k<worker.length;k++){
            while(j<difficulty.length && difficulty[j]<=worker[k]){
                maxProfit = maxProfit>profit[j]?maxProfit:profit[j];
                j++;
            }
            totalProfit += maxProfit;
            workerBest[k] = maxProfit;
            System.out.println("maxProfit "+maxProfit+" , j "+j+" , k "+ k);
        }
        return totalProfit;
    }
    public void sort(int[] mainArray,int[] appendArray){
        quickSort(0,mainArray.length-1,mainArray,appendArray);
    }
    public void quickSort(int start,int end, int[] mainArray,int[] appendArray){
        int i = start;
        int j = end;
        boolean flag = true;
        if(i>=j){
            return;
        }
        while(i!=j){
            if(flag){
                if(mainArray[i]>mainArray[j]){
                    swap(i,j,mainArray,appendArray);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(mainArray[i]>mainArray[j]){
                    swap(i,j,mainArray,appendArray);
                    flag = true;
                }else{
                    j--;
                }
            }
        }
        quickSort(start,i-1,mainArray,appendArray);
        quickSort(i+1,end,mainArray,appendArray);
    }
    public void swap(int i,int j, int[] mainArray,int[] appendArray){
        int temp1 = mainArray[i];
        mainArray[i] = mainArray[j];
        mainArray[j] = temp1;

        int temp2 = appendArray[i];
        appendArray[i] = appendArray[j];
        appendArray[j] = temp2;
    }
    public static void main(String[] args) {
        Solution4 s4 = new Solution4();
        int[] difficulty = {64,88,97};
        int[] profit = {53,86,89};
        int[] worker = {98,11,6};
        System.out.println(s4.maxProfitAssignment(difficulty,profit,worker));
        
    }
}