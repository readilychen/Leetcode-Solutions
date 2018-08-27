
class GroupsofSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Map<String, List<Integer>> indexMap = new HashMap<>();
        for(int i = 0; i<A.length; i++){
            String str = A[i];
            char[] charArray = str.toCharArray();
            String resultString = "";
            char[] evenCharArray = null;
            char[] oddCharArray = null;
            String evenStr = "";
            String oddStr = "";
            for(int j = 0; j<charArray.length; j++){
                //System.out.println("array length "+charArray.length);
                
                if(j % 2 ==0){
                    evenStr += String.valueOf(charArray[j]);
                }else{
                    oddStr += String.valueOf(charArray[j]);
                }
                evenCharArray = evenStr.toCharArray();
                oddCharArray = oddStr.toCharArray();
                Arrays.sort(evenCharArray);
                Arrays.sort(oddCharArray);
            }
            // System.out.println(str.length());
            // System.out.println(evenCharArray.length);
            // System.out.println(oddCharArray.length);
            
            for(int k = 0; k<str.length(); k++){
                    if(k % 2 == 0){
                        resultString += evenCharArray[k/2];
                    }else{
                        resultString += oddCharArray[k/2];
                    }
            }
            if(indexMap.containsKey(resultString)){
                List<Integer> indexList = indexMap.get(resultString);
                indexList.add(i);
            }else{
                List<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);
                indexMap.put(resultString,indexList);
            }
        }
        return indexMap.size();
    }
}