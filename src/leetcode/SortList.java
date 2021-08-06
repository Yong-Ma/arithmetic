package leetcode;
import java.util.*;
/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList {
//    public other.ListNode sortList(other.ListNode head) {
//        return sortList(head, null);
//    }
//
//    public other.ListNode sortList(other.ListNode head, other.ListNode tail) {
//        if (head == null) {
//            return head;
//        }
//        if (head.next == tail) {
//            head.next = null;
//            return head;
//        }
//        other.ListNode slow = head, fast = head;
//        while (fast != tail) {
//            slow = slow.next;
//            fast = fast.next;
//            if (fast != tail) {
//                fast = fast.next;
//            }
//        }
//        other.ListNode mid = slow;
//        other.ListNode list1 = sortList(head, mid);
//        other.ListNode list2 = sortList(mid, tail);
//        other.ListNode sorted = merge(list1, list2);
//        return sorted;
//    }
//
//    public other.ListNode merge(other.ListNode head1, other.ListNode head2) {
//        other.ListNode dummyHead = new other.ListNode(0);
//        other.ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//        while (temp1 != null && temp2 != null) {
//            if (temp1.val <= temp2.val) {
//                temp.next = temp1;
//                temp1 = temp1.next;
//            } else {
//                temp.next = temp2;
//                temp2 = temp2.next;
//            }
//            temp = temp.next;
//        }
//        if (temp1 != null) {
//            temp.next = temp1;
//        } else if (temp2 != null) {
//            temp.next = temp2;
//        }
//        return dummyHead.next;
//    }
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, (n1, n2) -> n1.val - n2.val);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
