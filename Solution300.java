class Solution300{
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i<dp.length; i++){
            dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length ;i++){
            for(int j = i-1; j>=0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
    public static void main(String[] args) {
        Solution300 s300 = new Solution300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(s300.lengthOfLIS(nums));
        
    }
}