import java.util.stack;
class Calculator{
    public static void main(String[] args) {
        public int calculate(String s) {
            s = s.replaceAll(" ","");
            Stack<Integer> operatorStack = new Stack<>();
            Stack<Integer> operandStack = new Stack<>();
            int from = 0;
            int to = 0;
            for(int i = 0; i< s.length(); i++){
                if(s.charAt(i)>=48 && s.charAt(i) <= 57){
                    continue;
                }else{
                    to = i;
                    int operator = Integer.valueOf(s.substring(from,to));
                    operatorStack.push(operator);
                    operandStack.push(s.charAt(i));
                    from = i + 1;
                }
            }
            operatorStack.push(Integer.valueOf(s.substring(from,s.length()));
            
            List<Integer> sumList = new ArrayList<Integer>();
            while(operatorStack.size()!=0){
                char operand = operandStack.pop();
                if(operand == '+'){
                    sumList.add(operatorStack.pop());
                }else if(operand == '-'){
                    sumList.add(-1*operatorStack.pop());
                }else if(operand == '*'){
                    
                }else{
                    
                }
            }
        }
        public static void main(String[] args) {
            
        }
    }
}