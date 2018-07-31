import java.util.List;
import java.util.ArrayList;
class Solution3{
    List<Integer[]> resultList = new ArrayList<>();
    public double largestSumOfAverages(int[] A, int K) {
        int sum;
        int[] sumArr = new int[A.length+1];
        sumArr[0] = 0;
        for(int i =1;i<=A.length;i++){
            sumArr[i] += A[i-1] + sumArr[i-1];
        }
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(0);
        combination(A.length,K-1,1,newList);
        double max = Double.MIN_VALUE;
        for(Integer[] integers : resultList){
            double tempMax = 0;
            for(int i =1;i<integers.length;i++){
                //System.out.print(integers[i]+" ");
                tempMax += (double)(sumArr[integers[i]] - sumArr[integers[i-1]])/ (integers[i] - integers[i-1]);
            }
            //System.out.println("tempMax "+tempMax );
            max = max > tempMax ? max : tempMax;
        }
        return max;
    }
    public void combination(int totalNum ,int selectedNum, int startIndex, List<Integer> selectedList){
        if(selectedNum == 0){
            selectedList.add(totalNum);
            Integer[] addInteger = new Integer[selectedList.size()];
            for(int i =0; i < selectedList.size();i++){
                addInteger[i] = selectedList.get(i);
            }
            selectedList.remove(selectedList.size()-1);
            resultList.add(addInteger);
            return;
        }
        for(int i = startIndex; i < totalNum-selectedNum+1;i++){
            selectedList.add(i);
            combination(totalNum,selectedNum-1,i+1,selectedList);
            selectedList.remove(selectedList.size()-1);
        }
    }
    //1,4,5,6,6,7,8,9
    //4.1 + 8 + 9
    //4.2 + 7 + 9
    // public double largestSumOfAverages(int[] A, int K) {
    //     //reverse order sort
    //     quickSort(A,0,A.length-1);
    //     int sum = 0;
    //     int mySum = 0;
    //     for(int i=0;i<A.length;i++){
    //         System.out.println(A[i]);
    //         sum+=A[i];
    //         if(i == K-2){
    //             mySum = sum;
    //         }
    //     }
    //     double lastAverage = (double) (sum - mySum)/(A.length - K+1);
    //     double totalAverage = mySum + lastAverage; 
    //     return totalAverage;
    // }
    //题目中说用相邻的，所以不能排序
    public void quickSort(int[] A,int start,int end){
        if(start > end){
            return;
        }
        int key = A[start];
        int i = start;
        int j = end;
        boolean flag = true;
        while(i!=j){
            if(flag){
                if(key < A[j]){
                    swap(A,i,j);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(key > A[i]){
                    swap(A,i,j);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        quickSort(A,start,i-1);
        quickSort(A,j+1,end);
    }
    public void swap(int[] A,int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        int[] A = {9,1,2,3,9};
        System.out.println(s3.largestSumOfAverages(A,3));
    }
}