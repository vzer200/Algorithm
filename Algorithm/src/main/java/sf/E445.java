package sf;

import LinkedList.ListNode;

public class E445 {
    //两数相加||
    public static ListNode addTwo(ListNode l1, ListNode l2) {

        int sum = 0;
        int c = 0;//进位
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum = x + y + c;
            c = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (c == 1) {
            cur.next = new ListNode(c);
        }
        return pre.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode L1 = fz(l1);
        ListNode L2 = fz(l2);
        ListNode newNode = addTwo(L1, L2);
        return fz(newNode);
    }


    public static ListNode fz(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = fz(p.next);
        p.next.next = p;
        p.next = null;
        return last;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        //跟人类习惯不一样反着进位
        //243 342 7243 3427
        //564 465  564 465
        //807 807 7807 7087
        //708
        // 创建链表2：4 -> 5 -> 6
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 调用addTwoNumbers方法
        ListNode result = addTwoNumbers(l1, l2);
        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

}
