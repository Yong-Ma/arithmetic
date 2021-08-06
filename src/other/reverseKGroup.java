package other;

import leetcode.ListNode;

public class reverseKGroup {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode node = head;
        int length = length(node);
        if (head == null) return null;
        if (k <= 0 || k > length) return head;

        int reversal = length - (length % k);
        int position = 0;
        ListNode result = new ListNode(0);
        ListNode result2 = result;
        ListNode temp = null;
        for (position = 0; position < reversal;) {
            ListNode newHead = null;
            //头插法
            for (int i = 0; i < k; i ++,position ++) {
                temp = node.next;
                node.next = newHead;
                newHead = node;
                node = temp;
            }
            result.next = newHead;
            for (int j = 0; j < k; j ++) {
                result = result.next;
            }

        }
        result.next = node;
        return result2.next;
    }

    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length ++;
            node = node.next;
        }
        return length;
    }
}
