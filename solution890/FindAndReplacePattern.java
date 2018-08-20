class findAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resultList = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            Map<Character, Character> myMap = new HashMap<>();
            boolean flag = false;
            for(int j = 0; j<words[i].length(); j++){
                if(myMap.containsKey(pattern.charAt(j))){
                    if(myMap.get(pattern.charAt(j)) == words[i].charAt(j)){
                        continue;
                    }else{
                        flag = true;
                        break;
                    }
                }else{
                    myMap.put(pattern.charAt(j),words[i].charAt(j));
                }
            }
            List<Character> repeatList = new ArrayList<>();
            for (Map.Entry<Character, Character> entry : myMap.entrySet()) {
                if(repeatList.contains(entry.getValue())){
                    flag = true;
                    break;
                }else{
                    repeatList.add(entry.getValue());
                }
            }
            if(!flag){
                resultList.add(words[i]);
            }
        }
        return resultList;
    }
}