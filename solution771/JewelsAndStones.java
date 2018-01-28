class JewelsAndStones{
    public int numJewelsInStones(String J, String S) {
        int count =0;
        for(int i =0;i<J.length();i++){
            char object = J.charAt(i);
            for(int j = 0;j<S.length();j++){
                if(object == S.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelsAndStones jas = new JewelsAndStones();
        System.out.println(jas.numJewelsInStones(J,S));
    }
}