class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<Character,Integer>();
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M',1000);
        //System.out.println((s.charAt(0)));
        int result = 0;
        boolean lastflag = false;
        if(s.length() == 1){
            return romanToIntMap.get(s.charAt(0));
        }
        
        for(int i = 1; i < s.length(); i++){
            char formerOne = s.charAt(i-1);
            char latterOne = s.charAt(i);
            if(romanToIntMap.get(formerOne) >= romanToIntMap.get(latterOne)){
                result += romanToIntMap.get(formerOne);
                if(i == s.length()-1){
                    result += romanToIntMap.get(latterOne);
                }
            }else{
                result +=  romanToIntMap.get(latterOne) - romanToIntMap.get(formerOne);
                if(i+1 == s.length()-1){
                    result += romanToIntMap.get(s.charAt(s.length()-1));
                }
                i++;
                
            }
        } 
        return result;
    }
}