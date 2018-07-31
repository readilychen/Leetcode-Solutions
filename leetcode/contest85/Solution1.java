
class Solution1{
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long x1_add = Math.abs(rec1[2] - rec1[0]);
        long x2_add = Math.abs(rec2[2] - rec2[0]);
        long x_add = x1_add + x2_add;
        //System.out.println(x_add);
        
        
        long x_max = Math.max(rec1[0],Math.max(Math.max(rec1[2],rec2[0]),rec2[2]));
        long x_min = Math.min(rec1[0],Math.min(Math.min(rec1[2],rec2[0]),rec2[2]));

        long x_dis = x_max - x_min;
        
        //System.out.println(x_dis);

        long y1_add = Math.abs(rec1[3] - rec1[1]);
        long y2_add = Math.abs(rec2[3] - rec2[1]);
        long y_add = y1_add + y2_add;
        //System.out.println(y_add);

        long y_max = Math.max(rec1[1],Math.max(Math.max(rec1[3],rec2[1]),rec2[3]));
        long y_min = Math.min(rec1[1],Math.min(Math.min(rec1[3],rec2[1]),rec2[3]));
        long y_dis = y_max - y_min;
        //System.out.println(y_dis);

        if(y_dis < y_add && x_dis < x_add){
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args) {
        String a = "i love you";
        
        
        Solution1 s1 = new Solution1();
        int[] rec1 = {-257926405,-680763313,702840196,454409669};
        int[] rec2 = {-275916328,-417802221,22808107,675629469};
        System.out.println(s1.isRectangleOverlap(rec1,rec2));
    }
}