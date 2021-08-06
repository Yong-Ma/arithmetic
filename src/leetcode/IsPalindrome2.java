package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome2 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        Map<Integer,Integer> map=new HashMap<>();
        int i=0,size=0;
        ListNode p=head;
        while(p!=null) {
            size++;
            p=p.next;
        }
        while (head!=null) {
            map.put(i,head.val);
            if(i>=size/2&&size%2==0) {
                if(!(map.get(i).intValue()==map.get(size-i-1).intValue()))
                    return false;
            }else if(i>=size/2+1&&size%2!=0) {
                if(!(map.get(i).intValue()==map.get(size-i-1).intValue()))
                    return false;
            }

            i++;
            head=head.next;
        }
        return true;
    }
}
