package other;

import leetcode.ListNode;

import java.math.BigInteger;

public class AddInList {
    public ListNode addInList (ListNode head1, ListNode head2) {
        BigInteger sum=getNum(head1).add(getNum(head2));
        String help=sum.toString();
        int size=help.length();
        ListNode head=new ListNode(0);
        ListNode p=head;
        for (int i = 0; i < size; i++) {
            int value=Integer.parseInt(help.substring(i,i+1)) ;
            p.next=new ListNode(value);
            p=p.next;
        }
        return head.next;
    }
    public BigInteger getNum(ListNode head) {
        StringBuilder stringBuilder=new StringBuilder();
        while(head!=null) {
            int num=head.val;
            stringBuilder.append(num);
            head=head.next;
        }
        return new BigInteger(stringBuilder.toString());
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(9);
        ListNode b=new ListNode(3);
        ListNode c=new ListNode(7);
        a.next=b;b.next=c;
        ListNode d=new ListNode(6);
        ListNode e=new ListNode(3);
        d.next=e;
        AddInList addInList=new AddInList();
        ListNode head=addInList.addInList(a,d);
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}

