class ListNode{
    int val;
    ListNode next;
    public ListNode(int num){
        val = num;
    }
}
class Solution2{
    public ListNode mySolution(ListNode l1,ListNode l2){
        ListNode prey = new ListNode(0);
        ListNode ans = new ListNode(0);
        prey = ans;
        int addToNext = 0;
        while(l1!=null||l2!=null||addToNext!=0){
            ans.next = new ListNode(0);
            ans = ans.next;
            int l1value = l1==null?0:l1.val;
            int l2value = l2==null?0:l2.val;
            ans.val = (addToNext + l1value + l2value)%10;
            addToNext = (l1value+l2value)/10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        return prey.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution2 s = new Solution2();
        ListNode result =  s.mySolution(l1,l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);

        ListNode a = new ListNode(3);
        ListNode b = a;
        System.out.println(a == b);
    }
}