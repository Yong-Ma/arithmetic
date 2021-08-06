package other;

import leetcode.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 *  给出的链表为:1->2->3->4->5, n= 2.
 *  删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是有效的
 * 请给出请给出时间复杂度为\ O(n) O(n)的算法
 *
 * 示例1
 * 输入
 * {1,2},2
 * 输出
 * {2}
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode res=head;
        int size=0;
        while(head!=null) {
            size++;
            head=head.next;
        }
        if(size==1)
            return null;
        if(size==n)
            return res.next;
        ListNode pre=res;
        int count=0;
        while(pre!=null) {
            count++;
            if(count==size-n) {
                pre.next=pre.next.next;
                break;
            }
            pre=pre.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;b.next=c;c.next=d;d.next=e;
        new RemoveNthFromEnd().removeNthFromEnd(a,2);
    }
}
