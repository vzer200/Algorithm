package sf;

import LinkedList.ListNode;

public class E148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }


    /**
     * 链表排序
     */
    public ListNode mergeSort(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
        return mergeTwoSort(left,right);
    }

    /**
     * 找到中点
     */

    public ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoSort(ListNode n1, ListNode n2) {

        ListNode s = new ListNode(-1);
        ListNode node = s;
        while(n1!=null&&n2!=null){
            if (n1.val<n2.val){
                node.next = n1;
                n1 = n1.next;
            }else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }

        if (n1!=null){
            node.next = n1;
        }else {
            node.next = n2;
        }

        return s.next;
    }

}
