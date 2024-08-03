package LinkedList;

/**
 * 有序链表去重
 */
public class E04Leetcode83 {

    // 方法1
    public ListNode deleteDuplicates1(ListNode head) {
        //节点数小于等于2的时候
        if (head ==null||head.next==null){
            return head;
        }
        ListNode s = new ListNode(-1,head);
        ListNode p1  = head;
        ListNode p2 ;
        while((p2 = p1.next)!=null){
            if (p1.val == p2.val){
                p1.next =p1.next.next;
            }else {
                p1 =p1.next;
            }
        }
        return s.next;
    }

    // 方法2
    public ListNode deleteDuplicates(ListNode p) {
        if (p==null  || p.next ==null){
            return p;
        }

        if (p.next.val == p.val){
            return deleteDuplicates(p.next);
        }else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3);
        System.out.println(head);
        System.out.println(new E04Leetcode83().deleteDuplicates(head));
    }
}
