object Solution{
    var dp:Array[Double] = null
    def new21Game(N:Int , K:Int, W:Int): Double ={
        if(K == 0 || K + W <= N){
            return 1;
        }
        dp = new Array[Double](N+1)
        dp(0) = 1 
        var result:Double = 0
        for(i <- 0 until N){
            var item:Double = calculateProbability(i,W)
            if(i >= K){
                result = result + item
            }
        }
        return result
    }
    //return the probability of get point i
    def calculateProbability(N:Int, W:Int):Double ={
        if(N < 0){
            return 0
        }
        if(N == 0){
            return 1
        }
        var dpn: Double = 0
        var flag:Boolean = true
        for(i <- 1 until W+1 ){
            if(N - i < 0){
                flag = false
            }
            if(flag){
                if(dp(N-i) != 0){
                    dpn = dpn + 1/W * dp(N-i);
                }else{
                    dpn = dpn + 1/W * calculateProbability(N - i, W)
                }
                dp(N) = dpn
            }  
        }
        return dpn
    }
    def main(args:Array[String]){
        print(new21Game(6,1,10))
    }
}
