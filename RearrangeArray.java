import java.util.*;
public class RearrangeArray{
    public char[] rearrange(char[] original){
        int[] count = new int[26];
        for(int i=0; i<original.length; i++){
            count[original[i] - 'A']++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(char c = 'A'; c < 'Z'; c++){
            pq.offer(new Node(c, count[c-'A']));
        }
        StringBuilder sb = new StringBuilder();
        Node pre = new Node('#',-1);
        while(pq.size() > 0){
            Node n = pq.poll();
            sb.append(n.c);

            if(pre.count > 0){
                pq.offer(pre);
            }
            n.count--;
            pre = n;

        }
        return sb.toString().toCharArray();
    }
    public static void main(String[] args) {
        RearrangeArray ra = new RearrangeArray();
        char[] original = {'A','D','Z','R','O','P'};
        char[] result = ra.rearrange(original);
        for(char c: result){
            System.out.print(c + " ");
        }
        
    }
}
class Node implements Comparator<Node>{
    public char c;
    public int count;
    public Node(char c, int count){
        this.c = c;
        this.count = count;
    }
    public int compare(Node n1, Node n2) {
        int count1 = n1.count;
        int count2 = n2.count;
        if(count1 > count2){
            return 1;
        }else if(count1 == count2){
            return 0;
        }else{
            return -1;
        }
   }
}