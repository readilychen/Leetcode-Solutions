class countAndSay {
    // 111221
    
    String resultString = "";
    public String countAndSay(int n) {
        String one = "1";
        n--;
        if(n == 0){
            return one;
        }
        while(n > 0){
            n--;
            String newOne = "";
            for(int i = 0; i < one.length(); i++){
                char charAtI = one.charAt(i);
                //System.out.println("first char "+charAtI);
                int count = 1;
                while(true){
                    if(i+1 < one.length() && one.charAt(i+1) == charAtI){
                        count++;
                        i++;
                    }else{
                        break;
                    }
                    //System.out.println("count "+count);
                }
                if(count > 1){
                    newOne = newOne + count + String.valueOf(charAtI);
                    //i--;
                }else{
                    newOne = newOne + "1" + String.valueOf(charAtI);
                }
            }
            one = newOne;
        }
        return one;
    }
}