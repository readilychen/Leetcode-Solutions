class Solution2{
    public int numComponents(ListNode head, int[] G) {
        sort(G);
        int count = 0;
        flag = false;
        while(head!=null){
            if(binarySearch(0,G.length-1,G,head.val)){
                flag = true;
                if(head.next == null){
                    count++;
                    break;
                }
                if(binarySearch(0,G.length-1,G,head.next.val)){
                    count ++;
                }else{
                    flag = false;
                }
            }
            if(){
                
            }
        }
        return count;
    }

    public boolean binarySearch(int start, int end, int[] G, int searchValue){
        if(start > end || G[start] > searchValue || G[end] < searchValue){
            return false;
        }
        if(start == end){
            return G[start] == searchValue;
        }
        int index = (start + end)/2;
        if(G[index] == searchValue){
            return true;
        }
        if(G[index] > searchValue){
            return binarySearch(start,index,G,searchValue);
        }else{
            return binarySearch(index+1,end,G,searchValue);
        }

    }
    public void sort(int[] G){
        quickSort(0,G.length-1,G);
    }
    public void quickSort(int start,int end, int[] G){
        if(start > end){
            return;
        }
        boolean flag = true;
        //The key value to compared with
        int value = G[start];
        int i = start;
        int j = end;
        while(i!=j){
            if(flag){
                if(G[i]>G[j]){
                    swap(G,i,j);
                    flag = false;
                }else{
                    j--;
                }
            }else{
                if(G[i]>G[j]){
                    swap(G,i,j);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        quickSort(start,i-1,G);
        quickSort(i+1,end,G);
        return;
    }
    public void swap(int[] G, int i, int j){
        int temp = G[i];
        G[i] = G[j];
        G[j] = temp; 
    }
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int[] G = {3,4,5,6,2,3,4};
        s2.sort(G);
        System.out.println(s2.binarySearch(0,G.length-1,G,4));
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}