class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 && popped.length== 0){
            return true;
        }
        if(pushed.length != popped.length ){
            return false;
        }
        Stack<Integer> tempStack = new Stack<Integer>();
        int j = 0;
        tempStack.push(pushed[0]);
        for(int i = 1; i<pushed.length; i++){
            if(tempStack.size() > 0){
                while(tempStack.size() > 0 && tempStack.peek() == popped[j]){
                    j++;
                    tempStack.pop();
                }
                tempStack.push(pushed[i]);
            }
        }
        //System.out.println(tempStack);
        while(tempStack.size() > 0){
            if(tempStack.peek() == popped[j]){
                tempStack.pop();
                j++;
            }else{
                return false;
            }
        }
        
        if(j != popped.length){
            //System.out.println("down");
            return false;
        }
        return true;
    }
}