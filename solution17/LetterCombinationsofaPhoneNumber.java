class letterCombinationsofaPhoneNumber {
    List<String> resultString = new ArrayList<>();
    Map<Integer,String> intToChar = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        intToChar.put(2,"abc");
        intToChar.put(3,"def");
        intToChar.put(4,"ghi");
        intToChar.put(5,"jkl");
        intToChar.put(6,"mno");
        intToChar.put(7,"pqrs");
        intToChar.put(8,"tuv");
        intToChar.put(9,"wxyz");
        if(digits.length() == 0){
            return resultString;
        }
        getNumber(digits,"");
        return resultString;
    }
    public void getNumber(String digits, String combination){
        if(digits.length() == 1){
            String lastElemt = intToChar.get(Integer.valueOf(digits.charAt(0)) - 48);
            for(int i = 0;i<lastElemt.length();i++){
                String newCombination = combination + String.valueOf(lastElemt.charAt(i));
                resultString.add(newCombination);
            }
            return;
        }
        int firstElemt = Integer.valueOf(digits.charAt(0)) - 48;
        String myString = intToChar.get(firstElemt);
        for(int i = 0;i<myString.length();i++){
            char c = myString.charAt(i);
            String newDigits = digits.substring(1,digits.length());
            String newCombination = combination + String.valueOf(c);
            getNumber(newDigits, newCombination);
        }
        
    }
}