package sf;

import LinkedList.ListNode;

public class E23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int i = 0;
        int j = lists.length - 1;

        return split(lists, i, j);
    }

    private ListNode split(ListNode[] lists, int i, int j) {

        if (i==j){
            return lists[j];
        }

        int mid = (i + j) >>> 1;
        ListNode left = split(lists, i, mid);
        ListNode right = split(lists, mid + 1, j);
        return mergeTwoSort(left,right);
    }



    public ListNode mergeTwoSort(ListNode n1, ListNode n2){
        ListNode s = new ListNode(-1);
        ListNode n = s;
        while (n1!=null&&n2!=null){
            if (n1.val<n2.val){
                n.next = n1;
                n1 = n1.next;
            }else {
                n.next = n2;
                n2 = n2.next;
            }
            n = n.next;
        }
        if (n1!=null){
            n.next = n1;
        }else {
            n.next = n2;
        }
        return s.next;
    }



















    public ListNode split1(ListNode[] lists, int i, int j) {
        if (i == j) {
            //切分到头了
            return lists[i];//返回最后一个链表
        }

        int mid = (i + j) >>> 1;
        ListNode left = split1(lists, i, mid);//切分成左边的
        ListNode right = split1(lists, mid + 1, j);//切分成右边的
        return mergeTwoSort1(left, right);
    }

    public ListNode mergeTwoSort1(ListNode n1, ListNode n2) {
        ListNode s = new ListNode(-1);
        ListNode node = s;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 != null) {
            node.next = n1;
        } else {
            node.next = n2;
        }
        return s.next;
    }

}
