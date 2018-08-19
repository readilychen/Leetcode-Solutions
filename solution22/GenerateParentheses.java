class GenerateParentheses {
    // bruce force search:
    // O (n^3)
   
    // 1 -> ()
    // 2 -> (());()();
    // 3 -> (()()); ()(());((()));(()());(())();()()();()()();()(())
    // figure out the ways that way can 
    List<String> resultStringList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        Stack<Character> valueStack = new Stack<>();
        recurseSearch(valueStack, 0,  n);
        return resultStringList;
    }

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
            recurseSearch(valueStack, leftValue+1, n-1);
        }else{
            
            valueStack.push('(');
            recurseSearch(valueStack, leftValue+1, n-1);
            valueStack.pop();
            
            
            if(leftValue > 0){
                valueStack.push(')');
                recurseSearch(valueStack, leftValue-1, n); 
                valueStack.pop();
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