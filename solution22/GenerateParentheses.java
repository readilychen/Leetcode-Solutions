import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    // bruce force search:
    // O (n^3)
   
    // 1 -> ()
    // 2 -> (());()();
    // 3 -> (()()); ()(());((()));(()());(())();()()();()()();()(())
    // figure out the ways that way can 
    List<String> resultStringList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        Stack<Character> valueStack = new Stack<>();
        // recurseSearch(valueStack, 0,  n);
        recurseSearch1(valueStack, 0,  n);
        return resultStringList;
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        gp.generateParenthesis(4);
    }
    /**
     * 
     * @param valueStack 当前的序列状态
     * @param leftValue 可以放入)的数量
     * @param n 可以放入(的数量
     */
    public void recurseSearch1(Stack<Character> valueStack, int leftValue, int n){
        if(n == 0) {
            String result = "";
            //说明(此时已经放完了 可以拼)出结果
            for(Character ch : valueStack) {
                result += "" + ch;
            }
            while(leftValue > 0) {
                result += ""+')';
                leftValue--;
            }
            System.out.println(result);
            return;
        }

        //初始状态下 栈为空
        if(valueStack.size() == 0) {
            valueStack.push('(');
            recurseSearch1(valueStack, leftValue + 1, n - 1);
        } else {
            //pos1
            valueStack.push('(');
            recurseSearch1(valueStack, leftValue + 1, n - 1);
            
            //回溯pos1的操作 尝试放入)替代pos1处放入的(,  能放入的前提是leftValue>0
            valueStack.pop();

            if(leftValue > 0) {
                //pos2
                valueStack.push(')');
                recurseSearch1(valueStack, leftValue - 1, n);
                //回溯pos2的操作
                valueStack.pop();
            }
        }

    }

    /**
     * 
     * @param valueStack 用于回溯状态的栈
     * @param leftValue 栈里未被抵消的(的数量 也就是可以放入)的数据
     * @param n 还能放多少个符号(到栈里
     */
    public void recurseSearch(Stack<Character> valueStack, int leftValue, int n){
        if(n == 0){
            String result = "";
            for(Character ch: valueStack){
                result += String.valueOf(ch);
            }
            while(leftValue != 0){
                leftValue-=1;
                result += ")";
            }
            resultStringList.add(result);
            System.out.println(result);
            return;
        }
        if(valueStack.size() == 0){
            valueStack.push('(');
            //每放入一个(,意味着可以放入的(少一个 可以放入的)多一个
            recurseSearch(valueStack, leftValue+1, n-1);
        }else{            
            valueStack.push('(');
            recurseSearch(valueStack, leftValue+1, n-1);

            //回溯
            valueStack.pop();
                        
            if(leftValue > 0){
                valueStack.push(')');
                //放入一个)相当于抵消一个(
                recurseSearch(valueStack, leftValue-1, n); 
                valueStack.pop();
            } else {
                //意味着没有可抵消的(了
            }
        }
    }
    

//     public void recurseSearch(Stack<Character> valueStack, String tempString, Stack<String> parenthesesString, int n){
//         if(n == 0){
//             String addToString = "";
//             String tempAddToString = "";
            
//             if(tempString != ""){
                
//             }
                
            
//             int count = 0;
            
//             System.out.println("before"+valueStack.size());
//             for(Character c: valueStack){
//                 tempAddToString = "("+tempAddToString+')';
//             }
            
//             System.out.println("after"+valueStack.size());
//             for(String value : parenthesesString){
//                 addToString = addToString + value;
//             }
            
//             addToString = tempAddToString + addToString;
//             System.out.println(addToString);
            
//             resultStringList.add(addToString);
//             return;
//         }
//         if(valueStack.size() == 0){
//             valueStack.push('(');
//             recurseSearch(valueStack, tempString, parenthesesString, n-1);
//         }else{
//             // we get the parenthese back form the stack
//             // push to the '('
//             valueStack.push('(');
//             recurseSearch(valueStack, tempString, parenthesesString, n-1);
//             valueStack.pop();
            
        
//             valueStack.pop();
//             System.out.println("wowo"+valueStack.size());
//             tempString = '(' + tempString + ')';
//             if(valueStack.size() == 0){
//                 parenthesesString.push(tempString);
//                 tempString = "";
//             }
//             recurseSearch(valueStack, tempString, parenthesesString, n);
                     
//         }
//     }
}