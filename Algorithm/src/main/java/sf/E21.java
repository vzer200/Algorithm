package sf;

import LinkedList.ListNode;

import java.util.List;

public class E21 {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {

        ListNode p = new ListNode(-1);
        ListNode pre = p;
        while(p1!=null&&p2!=null){
            if (p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!=null){
            p.next = p1;
        }

        if (p2!=null){
            p.next = p2;
        }
        return pre.next;
    }



    public ListNode mergeTwoLists_1(ListNode p1, ListNode p2) {
        //递归
        if (p1==null){
            return p2;
        }
        if (p2==null){
            return p1;
        }

        if (p1.val< p2.val){
            p1.next = mergeTwoLists_1(p1.next,p2);
            return p1;
        }else {
            p2.next = mergeTwoLists_1(p1,p2.next);
            return p2;
        }

    }



    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {

        //迭代法
        ListNode p  = new ListNode(-1);
        ListNode s  = p;

        //合并两个有序链表
        while(p1!=null&&p2!=null){

            if (p1.val<p2.val) {
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!=null){
            p.next = p1;
        }
        if (p2!=null){
            p.next = p2;
        }

        return s.next;
    }

    public ListNode mergeTwoLists2_1(ListNode p1, ListNode p2) {
        if (p1==null){
            return p2;
        }
        if (p2==null){
            return p1;
        }

        //递归法
        if (p1.val<p2.val){
            p1.next= mergeTwoLists2_1(p1.next,p2);
            return p1;
        }else {
            p2.next = mergeTwoLists2_1(p1,p2.next);
            return p2;
        }


    }

}
