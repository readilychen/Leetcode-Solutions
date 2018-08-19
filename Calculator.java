import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
class Calculator{
    public int calculate(String s){
            s = s.replaceAll(" ","");
            Stack<Integer> operatorStack = new Stack<>();
            Stack<Character> operandStack = new Stack<>();
            Stack<Integer> tempOperateStack = new Stack<>();
            Stack<Character> tempOperandStack = new Stack<>();
            int from = 0;
            int to = 0;
            operandStack.push('+');
            for(int i = 0; i< s.length(); i++){
                if(s.charAt(i)>=48 && s.charAt(i) <= 57){
                    continue;
                }else{
                    to = i;
                    int operator = Integer.valueOf(s.substring(from,to));
                    operatorStack.push(operator);
                    //System.out.println(i);
                    System.out.println(" i "+i);
                    System.out.println("char "+s.charAt(i));
                    operandStack.push(s.charAt(i));
                    from = i + 1;
                }
            }
            operatorStack.push(Integer.valueOf(s.substring(from,s.length())));
            


            List<Integer> sumList = new ArrayList<Integer>();
            

            System.out.println(operatorStack);
            System.out.println(operandStack);


            while(operatorStack.size()!=0){
                char operand = operandStack.pop();
                System.out.println("operand "+operand);
                //System.out.println(operand);
                if(operand == '+'){
                    if(tempOperateStack.size() != 0){
                        tempOperateStack.push(operatorStack.pop());
                        int value = getValue(tempOperateStack, tempOperandStack);
                        sumList.add(value);
                    }else{
                        sumList.add(operatorStack.pop());
                    } 
                }else if(operand == '-'){
                    if(tempOperateStack.size() != 0){
                        tempOperateStack.push(operatorStack.pop());
                        int value = getValue(tempOperateStack, tempOperandStack);
                        sumList.add(-1*value);
                    }else{
                        sumList.add(-1*operatorStack.pop());
                    }
                }else {

                    tempOperateStack.push(operatorStack.pop());
                    tempOperandStack.push(operand);
                }
            }
            int finalResult = 0;
            for(int i : sumList){
                System.out.println(i);
                finalResult += i;
            }
            return finalResult;
        }
        public int getValue(Stack<Integer> tempOperateStack, Stack<Character> tempOperandStack){
            int firstElem = tempOperateStack.pop();
            while(tempOperateStack.size()!=0){
                char operand = tempOperandStack.pop();
                if(operand == '*'){
                    firstElem *= tempOperateStack.pop();
                }else{
                    firstElem /= tempOperateStack.pop();
                }
            }
            return firstElem;
        }
    public static void main(String[] args) {
        //public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.calculate("2+2*3/4*8"));
    }
}