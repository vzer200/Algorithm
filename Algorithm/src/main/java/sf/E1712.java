package sf;

import LinkedList.ListNode;

public class E1712 {
    //交换链表中的节点，交换值不行
    public static ListNode swapNodes(ListNode head, int k) {

        //123 k=1 321 第一种情况，k在倒k的左侧
        //123 k=2 123 第二种情况，k和倒k重合
        //123 k=3 321 第三种情况  k在倒k的右侧
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre1 = dummy;//k的前一个节点
        ListNode left = dummy.next;
        ListNode pre2 = dummy;//倒k的前一个节点
        ListNode right = dummy.next;
        //找第k个节点
        for (int i = 1; i < k; i++) {
            pre1 = pre1.next;
            left = left.next;
        }

        ListNode cur = left;
        ListNode temp = left.next;//k节点的下一个节点
        //找到倒k
        while (cur.next != null) {
            pre2 = pre2.next;
            right = right.next;
            cur = cur.next;
        }
        if (right==left){
            return dummy.next;
        }else if (left==pre2){
            //k  倒k
            swapAdjust(pre1);
        }else if (right==pre1){
            swapAdjust(pre2);
        }else {
            swapRemote(pre1,pre2);
        }
        return dummy.next;
    }

    //考虑两种特殊情况： ①、倒数第k个节点刚好在第k个节点的左侧一个节点
    // ②、第k个节点刚好在倒数第k个节点的右侧一个节点
    public static void swapAdjust(ListNode pre){
        //交换pre后面的两个节点
        ListNode node1=pre.next;
        ListNode node2=node1.next;
        ListNode post=node2.next;
        node1.next=post;
        node2.next=node1;
        pre.next=node2;

    }

    public static void swapRemote(ListNode pre1,ListNode pre2){
        //交换两个不相邻的节点
        ListNode node1=pre1.next;
        ListNode node2=pre2.next;
        ListNode post1=node1.next;
        ListNode post2=node2.next;
        pre1.next=node2;
        node2.next=post1;
        pre2.next=node1;
        node1.next=post2;

    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = swapNodes(head, 2);
        System.out.println(result);
    }

}
