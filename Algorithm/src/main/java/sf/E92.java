package sf;

import LinkedList.ListNode;

public class E92 {

    //一步步进阶，先反转链表，再反转前n个链表
    //最后反转区间的链表
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode p, int n) {
        //反转前n个链表节点
        if (n==1){
           successor = p.next;
           return p;
        }
        //1->2->3->4->5
        //1<-2<-3   4->5
        //1指向4
        ListNode last = reverseN(p.next,n-1);
        p.next.next=p;
        p.next = successor;
        return last;

    }

    ListNode reverseBetween(ListNode head, int m, int n) {
      if (m==1){
          return reverseN(head,m);
      }
        ListNode last = reverseBetween(head.next, m - 1, n - 1);
        head.next = last;
        return head;
    }
    public ListNode reverseBetween2(ListNode head, int m, int n) {

        ListNode DyNode = new ListNode(0);
        DyNode.next = head;
        ListNode g  = DyNode;
        ListNode p  = DyNode.next;;
        for (int i = 1; i < m; i++) {
            g = g.next;
            p = p.next;
        }
        for (int i = 0; i < n-m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;

        }

        return DyNode.next;
    }


    public static void main(String[] args) {

        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);


        // 反转链表中的 2 到 4 之间的节点
        ListNode newHead = new E92().reverseBetween(o1, 2, 4);


        // 打印反转后的链表
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");

    }

}
