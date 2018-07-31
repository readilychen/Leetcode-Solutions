public class solution2{
    public static void main(String[] args) {
       solution2 s2 = new solution2();
       //construct the listnode
       ListNode l1 = new ListNode(0);
       //l1temp.next = new ListNode(3);
       System.out.println(s2.printListNode(l1));

       ListNode l2 = new ListNode(0);
       
       System.out.println(s2.printListNode(l2));
       
       ListNode l3 = s2.addTwoNumbers(l1,l2);
       System.out.println(s2.printListNode(l3));

    }
    public String printListNode(ListNode l){
       StringBuilder sb =new StringBuilder();
       if(l==null){
            return "list node is null";
       }else{
            while(true){
                String value = String.valueOf(l.val);
                sb.append(value);
                l = l.next;
                if(l!=null){
                    sb.append(" -> ");
                }else{
                    break;
                }
            }
            return sb.toString();
       }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //solution1(ListNode l1, ListNode l2);
        int addToNext = 0;
        ListNode resultList = new ListNode(0);
        ListNode tempNodes = new ListNode(0);
        int value1 = 0;
        int realValue1 =l1.val+l2.val+addToNext ;
        if(realValue1>=10){
                value1 = realValue1 - 10;
                addToNext = 1;
        }else{
                value1 = realValue1;
                addToNext = 0;
        }
        System.out.println("value1="+value1);
        resultList.val = value1;
        l1 = l1.next;
        l2 = l2.next;         
        boolean isfirst = true;
        while(l1 != null | l2 != null | addToNext != 0 ){
            if(isfirst){
                isfirst = false;
                resultList.next = tempNodes;
            }else{
                tempNodes.next = new ListNode(0);
                tempNodes = tempNodes.next;
            }
            if(l1 == null && l2!= null){
                int realValue = addToNext + l2.val;
                if(realValue>=10){
                    tempNodes.val = realValue - 10; 
                    addToNext =1;
                }else{
                    tempNodes.val = realValue;
                    addToNext =0;
                }
                l2 = l2.next;
            }else if (l1 != null && l2 == null){
                int realValue = addToNext + l1.val;
                if(realValue>=10){
                    tempNodes.val = realValue - 10; 
                    addToNext =1;
                }else{
                    tempNodes.val = realValue;
                    addToNext =0;
                }
                l1 = l1.next;
            }else if (l1 != null && l2!=null){
                int value = 0;
                int realValue =l1.val+l2.val+addToNext ;
                if(realValue>=10){
                    value = realValue - 10;
                    addToNext = 1;
                }else{
                    value = realValue;
                    addToNext = 0;
                }
                tempNodes.val =  value;
                l1= l1.next;
                l2=l2.next;
            }else{
                tempNodes.val = 1;
                addToNext = 0;
            }
        }     
        return resultList;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}