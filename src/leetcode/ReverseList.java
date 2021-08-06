package leetcode;


public class ReverseList  {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        head.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=null;
        
        head=reverseList(head);
        while (head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
        
    }
    public static ListNode reverseList(ListNode head) {
        ListNode listNode = null;
        while(head!=null) {
            ListNode temp=listNode;
            listNode=new ListNode(head.val) ;
            listNode.next=temp;
            head=head.next;
        }
        return listNode;
    }
}