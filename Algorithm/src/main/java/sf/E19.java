package sf;

import LinkedList.ListNode;

public class E19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        //递归思路 比较难想到 有漏洞 第一个无法删除
        //增加烧饼节点
        ListNode s = new ListNode(-1,head);
        reverse(s,n);
        return s.next;
    }

    public int reverse(ListNode p, int n){
        if (p==null){
            return 0;
        }
        int count = reverse(p.next, n);
        if (count==n){
            p.next = p.next.next;
        }
        return count+1;
    }

    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        //快慢指针法 要删倒数第二个 先找到倒数第三个 主要是思路很难想到
        //增加烧饼节点
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;

        for (int i = 0; i < n+1; i++) {
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return s.next;
    }

   /* public static ListNode removeNthFromEnd_2(ListNode head, int n){

        ListNode s = new ListNode(-1,head);
        ListNode next = reverse(s);
        ListNode cur = next;
        ListNode pre = new ListNode(-1,cur);
        while(cur!=null&&cur.next!=null){
            n--;
            if (n==0){
                pre.next = pre.next.next;
            }
            pre =cur;

            cur =cur.next;

        }
        ListNode result = reverse(next);
        return result.next;
    }

    public static ListNode reverse(ListNode p){
        if (p==null||p.next==null){
            return p;
        }
        ListNode reverse = reverse(p.next);
        p.next.next = p;
        p.next = null;
        return reverse;
    }*/



    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        //迭代法
        //快慢指针 要设置哨兵节点
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return s.next;
    }

    public ListNode removeNthFromEnd2_1(ListNode head, int n) {
        //递归法
        ListNode s  = new ListNode(-1,head);
        reverse2(s,n);
        return s.next;
    }

    public int reverse2(ListNode p, int n){
        if (p==null){
            return 0;
        }

        int count = reverse2(p.next, n);
        if (count==n){
            //表示找到了删除位置
            p.next = p.next.next;
        }
        return count+1;
    }



    public ListNode removeNthFromEnd3_1(ListNode head, int n) {
        //递归
        ListNode s = new ListNode(-1,head);
        reverse3(s,n);
        return s.next;
    }

    public int reverse3(ListNode p, int n) {
        if (p==null){
            return 0;
        }


        int count = reverse3(p.next, n);
        if (count==n){
            p.next = p.next.next;
        }

        return count+1;
    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        //迭代
        //如果创建三个对象的话 s就没有意义了 只能创造一个对象
      ListNode p1 = new ListNode(-1,head);
      ListNode p2 = new ListNode(-1,head);
      ListNode s = new ListNode(-1,head);
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return s.next;
    }



    public ListNode removeNthFromEnd4(ListNode head, int n) {
        //迭代法
        ListNode s = new ListNode(-1,head);
        ListNode p2 = s;
        ListNode p1 = s;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }

        while (p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return s.next;
    }

    public ListNode removeNthFromEnd4_1(ListNode head, int n) {
        //递归
        ListNode s = new ListNode(-1,head);
        reverse4(s,n);
        return s.next;
    }

    public int reverse4(ListNode head, int n) {
        if (head==null){
            return 0;
        }

        int count = reverse4(head.next, n);
        if (count==n){
            head.next = head.next.next;
        }
        return count+1;
    }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        removeNthFromEnd2(n,1);

    }

}
