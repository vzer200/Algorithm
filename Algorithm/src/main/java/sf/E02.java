package sf;

import LinkedList.ListNode;

public class E02 {
    //两数相加
    //987
    // 23
    //1010

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链表反转，创建新链表，将链表最末尾的节点返回到新链表的头部
//先将链表对应位置相加再倒转
//如果链表较短则在前面补0；
        ListNode pre = new ListNode(0);
        int c = 0;//c为进位位
        ListNode cur = pre;
        while (l1 != null || l2!= null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //需要考虑进位问
            int sum = x + y + c;
            c = sum / 10;
            sum = sum % 10;
           cur.next = new ListNode(sum);
           cur = cur.next;
                    //假设需要进位
            //多进位出来的数字需要给出空位

            //9,9,9,9,9,9,9
//          9,9,9,9
//  1,0,0,0,9,9,9,8

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (c==1){
            cur.next = new ListNode(c);
        }
        return pre.next;
    }


    public ListNode method(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode Last = method(p.next);
        p.next.next = p;
        p.next = null;
        return Last;
    }



    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //预先指针
        int c = 0; //进位
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        while(l1!=null||l2!=null){
            int x = l1 == null? 0:l1.val;
            int y = l2 == null? 0:l2.val;
            int sum = x+y+c;
            c = sum/10;
            sum = sum%10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1!=null){
                l1 = l1.next;
            }

            if (l2!=null){
                l2 = l2.next;
            }
        }

        if (c>0){
            cur.next = new ListNode(c);
        }

        return pre.next;
    }




    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        //预先指针
       ListNode cur = new ListNode(-1);
       ListNode pre = cur;
       int z = 0;
       while(l1!=null||l2!=null){
           int x = l1 ==null?0:l1.val;
           int y = l2 ==null?0:l2.val;
           int sum = x+y+z;
           z = sum/10;
           sum = sum%10;
           cur.next = new ListNode(sum);
           cur =cur.next;
           if (l1!=null){
               l1 = l1.next;
           }
           if (l2!=null){
               l2 = l2.next;
           }
       }

       if (z!=0){
           cur.next = new ListNode(z);
       }

       return pre.next;
    }

}
