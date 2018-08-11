class ZigZagConversion{
    public String convert(String s, int numRows){
        if(s == null || numRows == 1){
            return s;
        }

        if(numRows == 2){
            StringBuilder sbup = new StringBuilder();
            StringBuilder sbdown = new StringBuilder();
            for(int i =0; i<s.length(); i++){
                if(i%2 == 0){
                    sbup.append(s.charAt(i));
                }else{
                    sbdown.append(s.charAt(i));
                }
            }
            return sbup.append(sbdown.toString()).toString();

        }

        int colNumber;
        int groupItemCount = numRows + numRows - 2;
        int groupNumber = s.length() / groupItemCount;
        int remainItemCount = s.length() % groupItemCount;

        int perGroupCol = 1 + numRows - 2;
        if(remainItemCount <= numRows){
            colNumber = perGroupCol * groupNumber + 1;
        }else{
            colNumber = perGroupCol * groupNumber + remainItemCount - numRows + 1;
        }
        // System.out.println(colNumber);
        // System.out.println(groupItemCount);
        // System.out.println(groupNumber);
        // System.out.println(remainItemCount);
        // System.out.println(perGroupCol);

        Character[][] array = new Character[numRows][colNumber];
        StringBuilder resultString = new StringBuilder();
        int stageA = numRows;
        int stageB = numRows - 2;
        // means which stage the current char is in, true means stageA, false means stageB
        boolean flag = true;
        int currentCol = 0;
        for(int i = 0 ;i < s.length(); i++){
            if(flag){
                System.out.println(currentCol);
                array[numRows-stageA][currentCol] = s.charAt(i);
                if(stageA == 1){
                    flag = false;
                    stageB = numRows - 2;
                }else{
                    stageA--;
                }
            }else{
                System.out.println("dd"+currentCol);
                if(stageB == numRows-2){
                    currentCol++;
                }
                array[stageB][currentCol] = s.charAt(i);
                if(stageB == 1){
                    flag = true;
                    stageA = numRows;
                }else{
                    stageB--;
                }
                currentCol++;
            }
        }
        for(int i= 0;i<numRows;i++){
            for(int j=0;j<colNumber;j++){
                if(array[i][j] != null){
                    resultString.append(array[i][j]);
                }
            }
        }

        return resultString.toString();
    }
    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("abcddddddcbbbsdfa",2));
        
    }
}