class Solution3{
    public int nthMagicalNumber(int N, int A, int B) {
        boolean flag = true;
        long nthvalue;
        //int currentMin;
        int currentMax;
        if(A > B){
            currentMax = A;
            //currentMin = B;
            nthvalue = B;
            flag = false;
            if(A%B == 0){
                return (int)(B * N % (1e9 + 7));
            }
        }else if(A < B){
            currentMax = B;
            //currentMin = A;
            nthvalue = A;
            flag = true;
            if(B%A == 0){
                return (int)(A * N % (1e9 + 7));
            }
        }else{
            System.out.println(A);
            System.out.println(N);
            
            return (int)(A * N % (1e9 + 7));
        }
        
        
        int totalSize = 1;
        int Ascale = 1;
        int Bscale = 1;
        

                
        while(++totalSize <= N){
            System.out.println("Ascale "+Ascale);
            System.out.println("Bscale "+Bscale);
            System.out.println("nthvalue "+nthvalue);
            System.out.println();
            if(flag){
                Ascale++;
                int AtempValue = A*Ascale;
                if(AtempValue > currentMax){
                    flag = false;
                    currentMax = AtempValue;
                    nthvalue = B * Bscale;
                }else{
                    nthvalue = AtempValue;
                    if(AtempValue == currentMax){
                        totalSize--;
                    }
                }
            }else{
                Bscale++;
                int BtempValue = B*Bscale;
                if(BtempValue > currentMax){
                    flag = true;
                    currentMax = BtempValue;
                    nthvalue = A * Ascale;
                }else{
                    nthvalue = BtempValue;
                    if(BtempValue == currentMax){
                        totalSize--;
                    }
                }
            }
           
        }
        return (int)(nthvalue%(1e9+7));
        
    }
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        System.out.println(s3.nthMagicalNumber(1000000000,40000,40000));
    }
}