class Solution {
    public int[] diStringMatch(String S) {
        int front = 0;
        int last = S.length();
        int[] result = new int[S.length()+1];
        
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'D'){
                result[i] = last;
                last--;
            }else if(S.charAt(i) == 'I'){
                result[i] = front;
                front++;
            }
        }
        result[S.length()] = last;
        return result;
    }
}