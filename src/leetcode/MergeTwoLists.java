package leetcode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        ListNode listNode=new ListNode(Integer.MAX_VALUE);
        ListNode pos=listNode;
        while(l1!=null&&l2!=null) {
            if(l1.val<=l2.val) {
                pos.next=new ListNode(l1.val);
                l1=l1.next;
            }
            else {
                pos.next=new ListNode(l2.val);
                l2=l2.next;
            }
            pos=pos.next;
        }
        if(l1!=null)
            while (l1!=null) {
                pos.next=new  ListNode(l1.val);
                pos=pos.next;
                l1=l1.next;
            }
        else
            while (l2!=null) {
                pos.next=new  ListNode(l2.val);
                pos=pos.next;
                l2=l2.next;
            }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(4);
        a.next=b;
        b.next=c;
        ListNode d=new ListNode(1);
        ListNode e=new ListNode(3);
        ListNode f=new ListNode(4);
        d.next=e;
        e.next=f;
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(a,d);
    }
}
