package sf;

import LinkedList.ListNode;

import java.util.List;

public class E142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                ListNode p = slow;
                ListNode s = head;
                while (p!=s){
                    s=s.next;
                    p=p.next;
                }
                return p;
            }
        }
        return null;
    }


    public ListNode detectCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                //第一次相遇
                ListNode p = head;//
                while (p!=slow){
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

}
