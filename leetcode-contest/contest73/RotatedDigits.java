class RotatedDigits{
    boolean isGoodnum = true;
    public int rotatedDigits(int N) {
        int count =0;
        for(int i=1;i<=N;i++){
            int comparedNum = rotated(i);
            System.out.println(comparedNum);
            if(comparedNum != i && isGoodnum){
                count++ ;
            }
            isGoodnum = true;
        }
        return count;
    }
    public int rotated(int N){
        int newNum = 0;
        int multiple = 1;
        while(N!=0){
            int num = N % 10;
            int newDigit = 0;
            if(num == 2 || num == 5){
                newDigit = num == 2?5:2;
            }else if(num == 6 || num == 9){
                newDigit = num == 6?9:6;
            }else if(num == 0 || num ==1|| num == 8){
                newDigit = num;
            }else{
                isGoodnum = false;
                newDigit = num;
            }
            newNum += newDigit * multiple;
            multiple *= 10;
            N/=10;
        }
        return newNum;
    }
    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        System.out.println(rd.rotatedDigits(857));
    }
}