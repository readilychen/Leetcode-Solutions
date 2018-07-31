class Solution1{
    public boolean rotateString1(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        System.out.println(a.length);
        System.out.println(b.length);
        if(a.length != b.length){
            return false;
        }
        int i =0;
        while(i != a.length){
            char[] c = new char[a.length];
            char temp = a[0];
            boolean isTrue;
            for(int j = a.length -1;j>0;j--){
                c[j-1] = a[j];
            }
            c[a.length-1]=temp;
            a = c;
            i++;
            if(String.valueOf(a).equals(String.valueOf(b))){
                return true;
            }   
            //System.out.println("string "+ String.valueOf(a));
        }
        return false;
    }
    public boolean rotateString(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        if(a.length != b.length){
            return false;
        }
        char firstElem = b[0];
        int myIndex = 0;
        for(int i = 0;i<a.length;i++){
                //i=2
                if(a[i] == firstElem){
                    myIndex += i;
                    char[] c = new char[a.length];
                    int tempIndex = i-1;
                    //k=4 k>2 
                    for(int k = a.length-1 ;k>=a.length - i;k--){
                        c[k] = a[tempIndex];
                        tempIndex--;
                    }
                    for(int j = a.length - 1;j>=i;j--){
                        c[j-i] = a[j];
                    }  
                    if(String.valueOf(c).equals(String.valueOf(b))){
                        return true;
                    } 
                    System.out.println(String.valueOf(c));
    
                } 
        }
        
        return false;
    }
    public static void main(String[] args) {
        Solution1 s1=new Solution1();
        System.out.println(s1.rotateString("vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg","fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf"));
        
    }
}
