public class ToBinary{
    public int toBinary(long input){
        int count = 0;
        String str = "";
        while(input > 0){
            long reminder = input % 2;
            str = str + String.valueOf(reminder);
            if(reminder == 1){
                count++;
            }
            input /= 2;
        }
        System.out.println(str);
        return count;
    }
    public static void main(String[] args) {
        ToBinary t = new ToBinary();
        System.out.println(t.toBinary(11));
    }
}