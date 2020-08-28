
public class ReverseKList {
     public static void main(final String[] args) {
        final ListNode list=ListNode.buildList(new String[]{"1","2"
        ,"3","4","5",
        "6","7","8","9","a"
    });
        list.print();
        ListNode rList = reverseK(list, 4);
        rList.print();
     }

     public static ListNode reverseK(ListNode head, int k) {
         if(k==1) {
             return head;
         }
         
        ListNode cur = head;
        ListNode newHead = head;
        ListNode prevTurnTail = null;
        boolean firstTrun = true;
        while(cur != null){
            int step = 0;
            ListNode turntail = cur;
            if(prevTurnTail!=null) {
                prevTurnTail.next = cur;
            }

            while(step < k && cur!=null) {
                if(firstTrun) {
                    newHead = cur;
                    prevTurnTail = head;
                }
                cur = cur.next;
                step++;
            }
            if(step == k) {
            } else {
                break;
            }

            //翻转一趟k
            ListNode turnCur = turntail;
            ListNode turnNextCur = turnCur.next;
            while(step-- > 1) {
                //"1",       "2",      "3"
                //turnCur turnNextCur temp
                ListNode temp = turnNextCur.next;    
                turnNextCur.next = turnCur;
                if(step == k - 1) {
                    turnCur.next = null;
                }

               
                turnCur = turnNextCur;
                turnNextCur = temp;
                //"1",       "2",      "3"
                //            turnCur  temp
                //                     turnNextCur
            }

            if(prevTurnTail != null) {
              if(firstTrun && cur==null) {

              } else {
                prevTurnTail.next = turnCur;
                //prevTurnTail变为本轮的tail 进行下一次k翻转
                prevTurnTail = turntail;  
              }
            }     
            firstTrun = false;
        }
        if(firstTrun) {
            return head;
        }

        return newHead;
     }
}
