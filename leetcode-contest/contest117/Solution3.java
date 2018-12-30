class Solution3 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, Integer> originMap = new HashMap<>();
        Map<String, Integer> capMap = new HashMap<>();
        Map<String, Integer> volMap = new HashMap<>();
        for(int i=0; i< wordlist.length; i++){
            originMap.put(wordlist[i], i);
            // change all to lower case and sort
            char[] charArrayCap = wordlist[i].toLowerCase().toCharArray();
            
            if(!capMap.containsKey(new String(charArrayCap))){
                capMap.put(new String(charArrayCap),i);
            }
            
            // change all to vol and sort
            char[] charArrayVol = wordlist[i].toLowerCase().toCharArray();
            for(int j=0; j<charArrayVol.length; j++){
                if(charArrayVol[j] == 'a' || charArrayVol[j] == 'e' || charArrayVol[j] == 'i' ||  charArrayVol[j] == 'o' || charArrayVol[j] == 'u' ){
                    charArrayVol[j] = 'a';
                }
            }
            
            if(!volMap.containsKey(new String(charArrayVol))){
                volMap.put(new String(charArrayVol),i);
            }
        }
        
        String[] correct = new String[queries.length];
        for(int i=0; i<queries.length; i++){
            if(originMap.containsKey(queries[i])){
                correct[i] = wordlist[originMap.get(queries[i])];
                continue;
            }
            
            char[] charArrayCap = queries[i].toLowerCase().toCharArray();
            
            String getStrCap = new String(charArrayCap);
            
            if(capMap.containsKey(getStrCap)){
                int index = capMap.get(getStrCap);
                correct[i] = wordlist[index];
                continue;
            }
            
            char[] charArrayVol = queries[i].toLowerCase().toCharArray();
            
            for(int j=0; j<charArrayVol.length; j++){
                if(charArrayVol[j] == 'a' || charArrayVol[j] == 'e' || charArrayVol[j] == 'i' ||  charArrayVol[j] == 'o' || charArrayVol[j] == 'u' ){
                    charArrayVol[j] = 'a';
                }
            }
            
            String strVol = new String(charArrayVol);
            //System.out.println("getStrCap"+strVol);
            if(volMap.containsKey(strVol)){
                correct[i] = wordlist[volMap.get(strVol)];
                continue;
            }
            correct[i] = "";
            
            
        }
        return correct;
    }
}