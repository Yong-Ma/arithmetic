package leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
//    public other.ListNode addTwoNumbers(other.ListNode l1, other.ListNode l2) {
//        long sum=getNum(l1)+getNum(l2);
//        if(sum==0)
//            return new other.ListNode(0);
//        long yushu=0;
//        other.ListNode root=new other.ListNode(Integer.MAX_VALUE);
//        other.ListNode pos =root;
//        while(sum>0) {
//            yushu=sum%10;
//            pos.next=new other.ListNode((int)yushu);
//            pos=pos.next;
//            sum/=10;
//        }
//        return root.next;
//    }
//    public long getNum(other.ListNode listNode) {
//        long wei=0;  //表示位数
//        long sum=0;
//        while(listNode!=null) {
//            long num;
//            num=listNode.val*(long)Math.pow(10,wei);
//            sum+=num;
//            listNode=listNode.next;
//            wei++;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        ListNode a=new ListNode(9);
        ListNode b=new ListNode(9);
        ListNode c=new ListNode(9);
        ListNode d=new ListNode(9);
        ListNode e=new ListNode(9);
        ListNode f=new ListNode(9);
        ListNode g=new ListNode(9);
        ListNode h=new ListNode(9);
        ListNode i=new ListNode(9);
        ListNode j=new ListNode(9);
        ListNode k=new ListNode(9);
        ListNode z=new ListNode(1);
        z.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=k;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(a,z);
    }
}
