class Solution2{
    public String pushDominoes(String dominoes) {
        char[] finalNewState = dominoes.toCharArray();
        for(int i=0;i<dominoes.length();i++){
            finalNewState[i]='.';
        }
        int lastState = -1;
        for(int i =0;i<dominoes.length();i++){    
            if(dominoes.charAt(i) == '.'){
                continue;
            }else{
                if(lastState == -1){
                    if(dominoes.charAt(i) == 'L'){
                        for(int j = 0; j<i;j++){
                            finalNewState[j]='L';
                        }
                        finalNewState[i] = 'L';
                        System.out.println("haha "+String.valueOf(finalNewState));
                        lastState = i;
                    }else{
                        for(int j =0 ; j< i ; j++){
                            finalNewState[j]='.';
                        }
                        finalNewState[i] = dominoes.charAt(i);
                        System.out.println("haha "+String.valueOf(finalNewState));
                        lastState = i;
                    }
                }else{
                    if(dominoes.charAt(i) == 'L'){
                        if(dominoes.charAt(lastState) == 'L'){
                            for(int j = 0; j< i - lastState ;j++){
                                finalNewState[lastState + j]= 'L';
                            }
                            finalNewState[i] = 'L';
                            lastState = i;
                        }else if(dominoes.charAt(lastState) == 'R'){
                            System.out.println("haha "+String.valueOf(finalNewState));
                            int intermediateNum = i - lastState - 1;
                            int changeCount = intermediateNum / 2; 
                            System.out.println(i);
                            System.out.println(changeCount);
                            for(int j = 1;j<=changeCount;j++){
                                finalNewState[i-j] = 'L';
                            }
                            for(int j = 1;j<=changeCount;j++){
                                finalNewState[lastState+j]='R';
                            }
                            finalNewState[i] = 'L';
                            lastState = i;
                        }
                    }else if(dominoes.charAt(i) == 'R'){
                        if(dominoes.charAt(lastState)== 'R'){
                            int intermediateNum = i - lastState - 1;
                            for(int j = 1;j <= intermediateNum; j++){
                                finalNewState[lastState+j] = 'R';
                            }
                            finalNewState[i] = 'R';
                        }else{
                            finalNewState[i] = 'R';
                            //System.out.println(String.valueOf(finalNewState));
                        }
                        lastState = i;
                    }
                }
            }
        }
        if(lastState != -1 && dominoes.charAt(lastState) == 'R'){
            for(int j = dominoes.length()-1;j>lastState;j--){
                finalNewState[j] = 'R';
            }
        }
        return String.valueOf(finalNewState);
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        String dominoes = ".L.R.";
        String finalNewState = s2.pushDominoes(dominoes);
        System.out.println(finalNewState);
    }
}