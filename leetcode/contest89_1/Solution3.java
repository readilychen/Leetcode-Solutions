class Solution3{
    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
    }
}
class ExamRoom {
    int[] seatTable;
    public ExamRoom(int N) {
        seatTable = new int[N];
    }
    
    public int seat() {

        
    }
    
    public void leave(int p) {
        seatTable[p] = 0;
    }
}
