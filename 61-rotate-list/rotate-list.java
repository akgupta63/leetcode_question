public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        k = k % len;
        if (k == 0) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newTail = slow;
        ListNode newHead = slow.next;
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}