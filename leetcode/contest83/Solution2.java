class Solution2{
    public String maskPII(String S) {
        int index = S.indexOf(String.valueOf('@'));
        if(index == -1){
            //Indicating it is a phone number
            return maskPhone(S);
        }else{
            //Indicating it is an email address
            return maskEmail(S,index);
        }
    }
    public String maskEmail(String email,int index){
        String lowerEmail = email.toLowerCase();
        String finalEmail = String.valueOf(lowerEmail.charAt(0));
        finalEmail += "*****";
        finalEmail += lowerEmail.charAt(index-1);
        finalEmail +=  "@";
        finalEmail += lowerEmail.substring(index+1,lowerEmail.length());
        return finalEmail;
    }
    public String maskPhone(String phone){
        String lowerPhone = phone.toLowerCase();
        String tempPhone = "";
        for(int i = 0;i<phone.length();i++){
            char c = phone.charAt(i);
            if(c == '+' || c == '-' || c == '(' || c == ')' || c == ' '){
                continue;
            }else{
                tempPhone += String.valueOf(c);
            }
        }
        String finalPhone = "";
        if(tempPhone.length() == 10){
            finalPhone = "***-***-";
            finalPhone += tempPhone.substring(tempPhone.length()-4,tempPhone.length());
        }else{
            int extra = tempPhone.length() - 10;
            String prefix = "+";
            for(int i =0;i<extra;i++){
                prefix += "*";
            }
            prefix += "-";
            finalPhone += prefix;
            finalPhone += "***-***-";
            finalPhone += tempPhone.substring(tempPhone.length()-4,tempPhone.length());
        }
        return finalPhone;
    }
    
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        String result = s2.maskPII("1(234)567-890");
        System.out.println(result);
    }
}