package sf;

import LinkedList.ListNode;

public class E234 {

    public boolean isPalindrome(ListNode head) {
        //回文链表 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

        //想要反转然后求解 发现1121通过不了
        ListNode reverse = reverse(head);
        while (head != null) {
            if (head.val != reverse.val)
                return false;
            reverse = reverse.next;
            head = head.next;

        }
        return true;
    }

    public ListNode reverse(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode listNode = reverse(p.next);
        p.next.next = p;
        p.next = null;
        return listNode;
    }


    ListNode tmp;

    public boolean isPalindrome_1(ListNode head) {
        //逆序打印 递归思路
        tmp = head;
        return reverse_1(head);
    }

    public boolean reverse_1(ListNode p) {
        if (p == null) {
            return true;
        }
        boolean res = reverse_1(p.next) && (tmp.val == p.val); //&& 两边都为true的时候才返回true
        tmp = tmp.next;
        return res;
    }


    public boolean isPalindrome_2(ListNode head) {
        //第二种思路 反转后半段 再与前半段比较
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }
        //经过循环找到链表中间点
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse_2(slow);
        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;


    }


    public ListNode reverse_2(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode listNode = reverse_2(p.next);
        p.next.next = p;
        p.next = null;

        return listNode;
    }




}
