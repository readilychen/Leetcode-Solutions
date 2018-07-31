import java.util.Stack;
class LongestValidParentheses{
    //使用栈解决这个问题
    public int longestValidParentheses2(String s){
        if(s==""){
            return 0;
        }
        Stack<Integer> indexStack = new Stack<Integer>();
        Stack<Character> myStack = new Stack<Character>();
        myStack.push(s.charAt(0));
        indexStack.push(0);
        for(int i =1;i<s.length();i++){
            char c = s.charAt(i);
            if(!myStack.empty()){
                if(c == ')' && myStack.peek() == '('){
                    myStack.pop();
                    indexStack.pop();
                }else{
                    indexStack.push(i);
                    myStack.push(c);
                }
            }else{
                indexStack.push(i);
                myStack.push(c);
            }
        }
        indexStack.push(s.length());
        int max = Integer.MIN_VALUE;
        int value = indexStack.pop();
        int newValue;
        int temp;
        while(!indexStack.empty()){
            newValue = indexStack.pop();
            temp = value - newValue -1;
            max = max<temp?temp:max;
            value = newValue;
        }
        max = max < value?value:max;
        return max;
    }
    //可以通过状态和状态转移方程解决，但是无法处理多层括号包含的结构
    public int longestValidParentheses1(String s) {
        if(s.equals("")){
            return 0;
        }
        int length = s.length();
        int[] fMax = new int[length];
        int fLast = 0 ;
        if(s.charAt(0) == '('){
            fLast ++;
        }else{
            fLast = 0;
        }
        for(int i=1;i<length;i++){
            if(fLast % 2 == 0){
                if(s.charAt(i)=='('){
                    fLast++;
                }else{
                    fLast = 0;
                }
            }else{
                if(s.charAt(i) == ')'){
                    fLast++;
                }else{
                    fLast = 1;
                }
            }
            if((fLast / 2) > fMax[i]){
                fMax[i] = fLast / 2;
            }else{
                fMax[i] = fMax[i-1];
            }
        }    
        return fMax[length-1] * 2;
    }
    public static void main(String[] args) {
        String testStr = "(()())())";
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses2(testStr));
    }
}