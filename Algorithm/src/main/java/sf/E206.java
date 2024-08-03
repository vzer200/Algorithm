package sf;

import LinkedList.ListNode;

public class E206 {


    public ListNode reverseList(ListNode head) {

        //迭代
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            //curr和pre都前进一位
            pre = curr;
            curr = next;


        }
        return pre;
    }

    //递归
    public static ListNode reverse(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode reverse = reverse(p.next);
        //递归 他这个函数会返回调用
        p.next.next = p;
        p.next = null;
        return reverse;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode reverseList2_1 = reverseList2_1(head);
        System.out.println(reverseList2_1);
    }


    public ListNode reverseList2(ListNode head) {

        //反转链表 迭代法
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {

            next = curr.next;
            curr.next = pre;
            //next = curr.next; 必须是next这一步在前面 第二步就改变指针方向了 如果放在后面的话就倒着走了
            //实际没有第三个节点指向第二个节点 只需要两个节点来进行箭头转换就行了
            pre = curr;
            curr = next;

        }

        return pre;
    }


    public static ListNode reverseList2_1(ListNode head) {
        if (head == null || head.next == null) {

            return head;
        }
        // null<-3 <- 4
        //                                 null<-2<-3
        //                                 null<-1<-2<-3<-4                                                                   4                  5
        ListNode listNode = reverseList2_1(head.next); //因为这里传的是head的next 返回的head是3 head.next是4 下一层返回的是4
        // 你传入的head.next 下一层转换为head listNode是4 后序没改变它的值 他一直都是4 然后你做的操作都是针对head 将头变为4 返回4
        head.next.next = head;
        head.next = null;
        return listNode;
    }


    public ListNode reverseList3(ListNode head) {
        //迭代法
        ListNode p = head;
        ListNode pre = null;
        ListNode tmp = null;
        //null-> 1 -> 2 ->3
        while (p != null) {
            tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;

        }

        return pre;
    }

    public ListNode reverseList3_1(ListNode head) {
        //递归
        if (head==null||head.next==null){
            return head;
        }

        ListNode listNode = reverseList3_1(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


}
