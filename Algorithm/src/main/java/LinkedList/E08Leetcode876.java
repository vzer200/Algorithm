package LinkedList;

import java.util.HashSet;
import java.util.List;

/**
 * 查找链表中间节点
 */
public class E08Leetcode876 {

    /*
                p1
                        p2
        1   2   3   4   5   null


                    p1
                                p2
        1   2   3   4   5   6   null
     */

    /**
     * @param head 头节点
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;

    }
    public ListNode swapPairs(ListNode head) {
//如果是单个节点不交换
        if(head == null||head.next ==null){
            return head;
        }
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;

        while(p1.next!=null&&p1.next.next!=null){
            ListNode first = p1.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            p1.next =second;
            p1 = first;

        }


        return s.next;
    }


    public static void main(String[] args) {
        ListNode head1 = ListNode.of(1, 2, 3, 4);
        System.out.println(new E08Leetcode876().swapPairs(head1));

     //   ListNode head2 = ListNode.of(1, 2, 3, 4, 5, 6);
     //   System.out.println(new E08Leetcode876().middleNode(head2));
    }
}
