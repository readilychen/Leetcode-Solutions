public class ListNode {
    public String value;    
    public ListNode next;


    public static ListNode buildList(String[] ele) {
        if(null == ele || ele.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        head.value = ele[0];
        ListNode cur = head;
        for(int index = 1; index < ele.length; index++) {
            ListNode node = new ListNode();
            node.value = ele[index];
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public void print() {
        System.out.print(this.value);
        if(this.next != null) {
            System.out.print(",");
            this.next.print();
        } else {
            System.out.print("\n");
        }
    }
}

