/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        temp.next = head;

        int i = 0;
        while (i < left - 1) {
            pre = pre.next;
            i++;
        }
        ListNode startRev = pre.next;
        ListNode then = startRev.next;
        i = 0;
        while (i < right - left) {
            ListNode preNext = pre.next;
            ListNode thenNext = then.next;

            pre.next = then;
            then.next = preNext;
            startRev.next = thenNext;
            then=thenNext;

            i++;
        }


        return temp.next;
    }
}
