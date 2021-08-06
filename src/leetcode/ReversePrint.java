package leetcode;

import java.util.ArrayList;

public class ReversePrint {
    static ArrayList<Integer> arrayList=new ArrayList<>();
    public static int[] reversePrint(ListNode head) {
         digui(head);
         int [] arr=new int[arrayList.size()];
         int i=0;
         for(int a:arrayList) {
             arr[i++]=a;
         }
         return arr;
    }
    private static  void digui(ListNode node) {
        if(node==null)
            return;
        digui(node.next);
        arrayList.add(node.val);
    }

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

        int [] arr=reversePrint(head);
        for(int i:arr) {
            System.out.println(i);
        }
    }
}



