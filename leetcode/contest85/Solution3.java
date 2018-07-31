import java.util.Arrays;
class Solution3{
    int globalW;
    double dp[] ;
    public double new21Game(int N,int K, int W){
        if(K = 0 || N >= K + W){
            return 1;
        }
        //dp[i]: the probability to get number i
        dp = new double[N+1];   
        double wSum = 1, res = 0;
        dp[0] = 1;
        for(int i = 1; i<= N ; i++){
            dp[i] = wSum / W;
            if(i<K){
                wSum += dp[i];
            }else{
                res += dp[i];
            }
            if(i - W >= 0){
                wSum -= dp[i-W];
            }
            return res;
        }
    }
    public double new21Game1(int N, int K, int W) {  
        dp = new int[N+1]; 
        int numqualify = 0;
        int numunqualify = 0;
        Arrays.fill(dp,-1);
        globalW = W;
        int from = K-W > 0 ? K-W : 0;
        for(int i = from; i < K ; i++){
            calculateDP(i);
            int item = dp[i];
            System.out.println("calculate i = "+ i + ", item = "+item );
            if(i == 0){
                //which means K < W 
                if(W > N){
                    numqualify += N - K + 1;
                    numunqualify = W - N;
                }else{
                    numqualify += W - K + 1;
                }
            }else{
                if(i + W > N){
                    numqualify += (N - K + 1) * item;
                    numunqualify += (i + W - N) * item;
                }else{
                    System.out.println(" ** "+(i+W));
                    numqualify += (i + W - K + 1) * item;
                }
            }
            System.out.println("i = "+ i +" , numqualify = "+ numqualify + ",numunqualify "+ numunqualify);
        }
        return (float)numqualify / (numqualify + numunqualify);
    }
    public int calculateDPTest(int target){
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        return calculateDPTest(target - 1) + calculateDPTest(target - 2) +
         calculateDPTest(target - 3) + calculateDPTest(target - 4)
         + calculateDPTest(target - 5) + calculateDPTest(target - 6) + calculateDPTest(target - 7);
    }
    public int calculateDP(int n){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        int dpn = 0;
        for(int i = 1; i <= globalW; i++) {
            if(n-i < 0){
                break;
            }
            if(dp[n-i] != -1){
                dpn += dp[n-i];
            }else{
                dpn += calculateDP(n-i);
            }
        }
        dp[n] = dpn;
        return dpn;
    }



    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        //System.out.println(s3.calculateDPTest(7));
        System.out.println(s3.new21Game(21,17,10));
    }
}