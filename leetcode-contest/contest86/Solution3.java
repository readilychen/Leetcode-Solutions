class Solution3{
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        if(S.length < 3){
            return result;
        }
        
        // for(int i = 0;i<S.length()-2;i++){
        //     for(int j = i+1;j<S.length()-1;j++){
        //         if(Integer.valueOf(S.charAt(i)) + Integer.valueOf(S.charAt(j)) == S.charAt(S.length()-1))){
        //             int firstValue = 0;
        //             int secondValue = 0;
        //             int sum = 0;
        //             for(int f = 0; f <= i; f++){
        //                 firstValue += firstValue * 10 + Integer.valueOf(S.charAt(f));
        //             }
        //             for(int s = i+1 ; s <= j ; s++){
        //                 secondValue += secondValue * 10 + Integer.valueOf(S.charAt(s));
        //             }
        //             for(int m = j+1; m < S.length(); m++){
        //                 sum += sum * 10 + Integer.valueOf(S.charAt(m));
        //             }
        //             if(firstValue + secondValue == sum){
        //                 result.add(firstValue);
        //                 result.add(secondValue);
        //                 result.add(sum);
        //             }
        //         }
        //     }
        // }
        // return result;   
        
    }
    
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        String S = ;
        List<Integer> result = s3.splitIntoFibonacci(S);
        for(int r : result){
            System.out.println(r);
        }
    }
}