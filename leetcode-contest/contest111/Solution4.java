class Solution {
    public String shortestSuperstring(String[] A) {
        List<String> resultList = new ArrayList<>(Arrays.asList(A));
        while(resultList.size() > 1){
            int max = Integer.MIN_VALUE;
            String replaceStr = "";
            String stringI = "";
            String stringJ = "";
            for(int i=0; i<resultList.size()-1; i++){
                for(int j=i+1; j<resultList.size(); j++){
                    String strI = resultList.get(i);
                    int strIlength = strI.length();
                    String strJ = resultList.get(j);
                    int strJlength = strJ.length();
                    // strI from back to front
                    // strJ from front to back
                    for(int k=1; k<Math.min(strIlength, strJlength); k++){
                        
                        if(strI.substring(strIlength-k).equals(strJ.substring(0,k))){
                            if(k > max){
                                max = k;
                                stringI = strI;
                                stringJ = strJ;
                                replaceStr = strI + strJ.substring(k);
                            }
                        }
                    }
                    for(int k=1; k<Math.min(strIlength, strJlength); k++){
                        if(strI.substring(0,k).equals(strJ.substring(strJlength-k))){
                            if(k > max){
                                max = k;
                                stringI = strI;
                                stringJ = strJ;
                                replaceStr = strJ + strI.substring(k);
                            }
                        }
                    }
                }          
            }
            if(replaceStr.equals("")){
                StringBuilder sb = new StringBuilder();
                for(String s : resultList){
                    sb.append(s);
                }
                return sb.toString();
            }
            resultList.remove(stringI);
            resultList.remove(stringJ);
            resultList.add(replaceStr);
        }
        return resultList.get(0);
    }
}