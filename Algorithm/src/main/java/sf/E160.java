package sf;

import LinkedList.ListNode;

public class E160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //相交节点  相同的值的节点并不意味着 这两个节点相交

        //走到尽头不见你 于是走你来时的 等到相遇时才发现 你也走过我来时的路

        //数学逻辑 headA a  headB b 相遇部分 m  a+m+b+m = b+m+a+m

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
           if (a!=null){
               a = a.next;
           }else {
               a = headB;
           }
            if (b!=null){
                b = b.next;
            }else {
                b = headA;
            }

        }

        return a;
    }




    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1!=p2){
            p1 = p1==null?headB:p1.next;
            p2 = p2==null?headA:p2.next;

        }

        return p1;
    }


}
