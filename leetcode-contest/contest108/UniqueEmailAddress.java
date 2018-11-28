class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> tempSet = new HashSet<>();
        
        for(int i=0; i<emails.length; i++){
            boolean at = false;
            boolean point = false;
            boolean plus = false;
            String email = emails[i];
            StringBuilder tempBuilder = new StringBuilder();

            for(int j=0; j<email.length(); j++){
                //System.out.println(email.charAt(j));
                if(email.charAt(j) =='@' ){
                    at = true;
                    tempBuilder.append(email.charAt(j));
                }else if(email.charAt(j) == '.' && !at){
                    point = true;
                    continue;
                }else if(email.charAt(j) == '+' && !at){
                    plus = true;
                    continue;
                }else{
                    if(plus && !at){
                        continue;
                    }
                    tempBuilder.append(email.charAt(j));
                }
                
                
            }
            tempSet.add(tempBuilder.toString());
        }
        //System.out.println(tempSet);
        return tempSet.size();
    }
}