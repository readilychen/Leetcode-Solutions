class Solution2{
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0){
            return 0;
        }else if(position.length ==1){
            return 1;
        }
       //firstly sort the position array and speed array
       sort(position,speed);

       for(int i = 0; i< position.length ;i++){
            System.out.print(position[i] + " , ");
       }
       System.out.println();
       for(int i = 0; i< position.length ;i++){
            System.out.print(speed[i] + " , ");
       }
       System.out.println();
       float[] time = new float[position.length];

       for(int i = position.length-1; i >= 0; i--){
            time[position.length-1 - i] = (target-position[i])/(float)speed[i];
       }
       System.out.println("time");
       for(int i = 0; i< position.length ;i++){
            System.out.print(time[i] + " , ");
       }

       int count = 0;
       boolean firstMeet = true;
       float largestTime = time[0];
       int index = -1;
       for(int i = 1;i < time.length; i++){
            if(largestTime < time[i]){
                index = i;
                largestTime = time[i];
                if(firstMeet){
                    count++;
                }
                firstMeet = true;
            }else{
                if(firstMeet){
                    count++;
                    firstMeet = false;
                }
            }
       }
       if(index == time.length-1 ){
            count++;
       }
       return count;
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
                    flag=true;
                }else{
                    i++;
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
        // int target  = 10;
        // int[] position = {6,8};
        // int[] speed = {3,2};
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        Solution2 s2 = new Solution2();
        System.out.println(s2.carFleet(target,position,speed));
    }
}