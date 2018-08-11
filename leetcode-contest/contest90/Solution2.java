import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
class Solution2 {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<S.length();i++){
            Character c = S.charAt(i);
            if(c == '('){
                stack.push("(");
            }else{
                // search top item
                String top = stack.peek();
                if(top.equals("(")){
                    stack.pop();
                    stack.push(String.valueOf(1));
                }else{
                    List<Integer> addList = new ArrayList<>();
                    while(!stack.empty() && !stack.peek().equals("(")){
                        Integer value = Integer.valueOf(stack.pop());
                        addList.add(value);
                    }
                    if(stack.empty()){
                        int count = 0;
                        for(Integer item: addList){
                            count += item;
                        }
                        stack.push(String.valueOf(count));
                    }else{
                        if(addList.size() == 1){
                            stack.pop();
                            stack.push(String.valueOf(2 * addList.get(0)));
                        }else{
                            int count = 0;
                            for(Integer item : addList){
                                count += item;
                            }
                            stack.pop();
                            Integer addValue = 2* count;
                            stack.push(String.valueOf(addValue));
                        }
                    }
                }
            }
        }
        int count = 0;
        while(!stack.empty()){

            count += Integer.valueOf(stack.pop());
        }
        return count;
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        String S = "(())";
        System.out.println(s2.scoreOfParentheses(S));
    }  
}