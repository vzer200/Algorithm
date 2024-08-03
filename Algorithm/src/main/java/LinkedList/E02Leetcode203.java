package LinkedList;

/**
 * 根据值删除节点
 */
public class E02Leetcode203 {
    /**
     * 方法1
     *
     * @param head 链表头
     * @param val  目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements1(ListNode head, int val) {
       //第一步设置一个哨兵节点
        ListNode s = new ListNode(-1,head);
        //第二步设置两个指针，用于删除节点
        ListNode p1 = s;
        ListNode p2;//p2表示要删除的节点
        while((p2 = p1.next)!=null){
            if (p2.val == val){
             //表示找到需要删除的节点
             p1.next = p2.next;
            }else{
                //没找到
                p1 = p1.next;
            }
            p2 = p1.next;
        }
        return s.next;
    }

    /**
     * 方法2
     *
     * @param p   链表头
     * @param val 目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements(ListNode p, int val) {
        if (p == null) {
            return null;

        }
        if (p.val == val){
            return removeElements(p.next, val);
        }else {
            p.next = removeElements(p.next,val);
            return p;
        }
    }

    public static void main(String[] args) {
      ListNode head = ListNode.of(1, 2, 6, 3, 6);
      // ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new E02Leetcode203()
                .removeElements(head, 6));
    }
}
