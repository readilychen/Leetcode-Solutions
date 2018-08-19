import java.util.Stack;
class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> validationStack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
             char c = s.charAt(i);
             if(c == '(' || c == '{' || c == '['){
                 validationStack.push(c);
             }else{
                 if(validationStack.size() != 0){
                     char topElem = validationStack.peek();
                     if(c == ')'){
                         if(topElem!='('){
                             return false;
                         }else{
                             validationStack.pop();
                         }
                     }else if(c == '}'){
                         if(topElem != '{'){
                             return false;
                         }else{
                             validationStack.pop();
                         }
                     }else{
                         if(topElem != '['){
                             return false;
                         }else{
                             validationStack.pop();
                         }
                     }
                 }else{
                     return false;
                 }
                 
             }
        }
        if(validationStack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}