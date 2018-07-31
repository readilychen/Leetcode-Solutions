class Solution3{
    public int consecutiveNumbersSum(int N) {
        int sum = 0;
        int count = 0;
        int finalCount = 0;
        while(sum < N){
            sum += count;
            count++;
            System.out.println("sum"+sum);
            System.out.println("N-sum"+(N-sum));
            System.out.println("count"+count);
            if((N-sum)!=0 &&(N-sum) % count == 0){
                finalCount++;
            }
            System.out.println("finalCount"+finalCount);
        }
        return finalCount;
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        System.out.println(s3.consecutiveNumbersSum(1));
        
    }
}