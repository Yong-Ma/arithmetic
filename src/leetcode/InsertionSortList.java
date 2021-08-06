package leetcode;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 1. 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if(head == null){
            return head;
        }

        // 2. 链表初始化操作
        ListNode dummyHead = new ListNode(0); // 引入哑节点
        dummyHead.next = head;                // 目的是在head之前插入节点
        ListNode lastSorted = head;           // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode curr = head.next;            // 维护curr 为待插入的元素并初始化

        // 3. 插入排序
        while(curr != null){
            if(lastSorted.val <= curr.val){     // 说明curr应该位于lastSorted之后
                lastSorted = lastSorted.next;   // 将lastSorted后移一位,curr变成新的lastSorted
            }else{                              // 否则,从链表头结点开始向后遍历链表中的节点
                ListNode prev = dummyHead;      // 从链表头开始遍历 prev是插入节点curr位置的前一个节点
                while(prev.next.val <= curr.val){ // 循环退出的条件是找到curr应该插入的位置
                    prev = prev.next;
                }
                // 以下三行是为了完成对curr的插入（配合题解动图可以直观看出）
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next; // 此时 curr 为下一个待插入的元素
        }
        // 返回排好序的链表
        return dummyHead.next;
    }
}
