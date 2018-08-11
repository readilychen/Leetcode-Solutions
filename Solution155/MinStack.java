class MinStack {
    private final int initialize = 10;
    int[] internalArray; 
    //Record the length of the stack
    int length;
    //Record the index of the stack
    int index;
    public int[] minList;
    public int min;
    /** initialize your data structure here. */
    public MinStack() {
        internalArray = new int[initialize];
        minList = new int[initialize];
        length = initialize ;
        index = 0;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(index > length){
            length += 50;
            int[] newArray = new int[length];
            for(int i =0;i<internalArray.length;i++){
                newArray[i]=internalArray[i];
            }
            internalArray = newArray;
        }
        internalArray[index] = x;
        min = min < x?min:x;
        System.out.println("min "+min);
        minList[index] = min;
        index++;
    }

    public void pop() {
        index -= 1;
        internalArray[index]=0;
        min = minList[index];
    }
    
    public int top() {
        int topIdn = index - 1;
        return internalArray[topIdn];
    }
    
    public int getMin() {
        int minNow = index -1 ;
        return minList[minNow];
    }
    public static void main(String[] args) {
         MinStack obj = new MinStack();
         obj.push(2147483647);
         obj.push(2147483647);
         obj.push(2147483646);
         int param_3 = obj.top();
         
         obj.pop();
         System.out.println("min "+obj.min);
         for(int i=0;i<obj.minList.length;i++){
            System.out.println(obj.minList[i]);
         }
         System.out.println(param_3);
       
 
    }
}
