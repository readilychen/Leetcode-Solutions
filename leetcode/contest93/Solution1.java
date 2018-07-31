class Solution1{
    public int binaryGap(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        if(N == 0){
            return 0;
        }
        int largest = Integer.MIN_VALUE;
        boolean falg = true;
        int firstPos = 0;
        int secondPos = 0;
        for(int i = 0;i<binary.length();i++){
            if(binary.charAt(i) == '1'){
                if(falg){
                    firstPos = i;
                    falg = false;
                }else{
                    largest = i - firstPos > largest ? i - firstPos : largest;
                    firstPos = i;
                }
            }
        }
        if(largest == Integer.MIN_VALUE){
            return 0;
        }
        return largest;
    }
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        System.out.println(s1.binaryGap(8));
    }
}