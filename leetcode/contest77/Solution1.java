class Solution1{
    public int[] numberOfLines(int[] widths, String S) {
        int lineNum = 1;
        int line = 0;
        for(int i =0;i<S.length();i++){
            int value = S.charAt(i);
            if(line + widths[value-97] <= 100){
                line+=widths[value-97];
            }else{
                lineNum++;
                line = 0;
                line+=widths[value-97];   
            }
        }
        int[] result = {lineNum,line};
        return result;
    }
    public static void main(String[] args) {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "bbbcccdddaaa";
        Solution1 s1 = new Solution1();
        int[] result = s1.numberOfLines(widths,S);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}