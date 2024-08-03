package sf;

import LinkedList.ListNode;

public class E24 {
    public ListNode swapPairs(ListNode head) {
        //递归
        if (head==null||head.next==null){
            return head;
        }

        ListNode newHead = head.next;
         head.next = swapPairs(newHead.next);
         newHead.next = head;
         return newHead;
    }



    public ListNode swapPairs_1(ListNode head) {
        //迭代
        if (head==null||head.next==null){
            return head;
        }

        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;

        while (p1.next!=null&&p1.next.next!=null){
            ListNode next = p1.next;
            ListNode n = next.next;
            next.next = n.next;
            n.next = next;
            p1.next = n;
            p1 = p1.next.next;

        }

        return s.next;
    }



    public ListNode swapPairs2(ListNode head) {

        //两两相交链表中的节点
        //迭代
        ListNode s = new ListNode(-1,head);
        ListNode p = s;
        while (p.next!=null&&p.next.next!=null){
            ListNode cur = p.next;
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            p.next = next;
            p = p.next.next;
        }

        return s.next;
    }


    public ListNode swapPairs2_1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }

        //递归
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }



    public ListNode swapPairs3(ListNode head) {
        //迭代法
        ListNode s = new ListNode(-1,head);
        ListNode p1 =s;
        while (p1.next!=null&&p1.next.next!=null){
            ListNode pre = p1.next;
            ListNode next = pre.next;
            pre.next = next.next;
            next.next = pre;
            p1.next = next;
            p1 = p1.next.next;
        }
        return s.next;
    }

    public ListNode swapPairs3_1(ListNode head) {
        //递归
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs3_1(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
