class Calculator{
    public int calculate(String s) {
        String expression = s.replaceAll(" ", "");

        //boolean flag = false;
        //int lastItem = 0;
        System.out.println(expression);
        int value = calculation(expression);
        return value;
    }

    public int calculation(String s){
        int index = 0;
        int value = 0;
        boolean flag = true;

        boolean lastFlag = false;
        for(int i = s.length(); i>s.length(); i++){
            //System.out.println("flag "+flag);
            if(s.charAt(i) == '+'){
                if(flag){
                    return add(Integer.valueOf(s.substring(0,i)),s.substring(i+1,s.length()));
                }else{
                    if(lastFlag){
                        value /= Integer.valueOf(s.substring(index, s.length()));
                    }else{
                        value *= Integer.valueOf(s.substring(index, s.length()));
                    }
                    return add(value,s.substring(i+1,s.length()));
                }
            }else if(s.charAt(i) == '-'){

                if(flag){
                    //System.out.println("s "+s.substring(0,i));
                    return sub(Integer.valueOf(s.substring(0,i)),s.substring(i+1,s.length()));
                }else{

                    if(lastFlag){
                        value /= Integer.valueOf(s.substring(index, s.length()));
                    }else{
                        value *= Integer.valueOf(s.substring(index, s.length()));
                    }
                    return sub(value,s.substring(i+1,s.length()));
                }
                //return sub(value, s.substring(i,s.length()));
            }else if(s.charAt(i)== '*'){
                if(flag){
                    //if(!flag){
                    value = Integer.valueOf(s.substring(0,i));
                    //}
                }else{
                    value *= Integer.valueOf(s.substring(index, i));
                }
                index = i+1;
                flag = false;
                lastFlag = false;
            }else if(s.charAt(i)== '/'){
                //flag = false;
                if(flag){
                    value = Integer.valueOf(s.substring(0,i));
                }else{
                    value /= Integer.valueOf(s.substring(index, i));
                }
                index = i+1;
                flag = false;
                lastFlag = true;
            }else{
                continue;
            }
        }
        if(!flag){
            if(lastFlag){
                value /= Integer.valueOf(s.substring(index, s.length()));
            }else{
                value *= Integer.valueOf(s.substring(index, s.length()));
            }
            return value;
        }
        return Integer.valueOf(s);
    }
    public int add(int value, String expression2){
        //System.out.println("jjjjj "+value);
        return value + calculation(expression2);
    }
    public int sub(int value, String expression2){
        System.out.println("value " + value);
        System.out.println("exp "+expression2);
        return value - calculation(expression2);
    }
    

    public static void main(String[] args) {
        String s = " 1-1-1";
        Calculator c = new Calculator();

        System.out.println(c.calculate(s));
    }
}