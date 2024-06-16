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
    public ListNode insertionSortList(ListNode head) {
        ListNode currTemp = head;
        ListNode sortedHead = null;

        while (currTemp != null) {
            ListNode next = currTemp.next;
            sortedHead = sortedList(sortedHead, currTemp);
            currTemp = next;
        }
        return sortedHead;
    }

    private ListNode sortedList(ListNode sortedHead, ListNode newNode) {
        if (sortedHead == null || sortedHead.val >= newNode.val) {
            newNode.next = sortedHead;
            return newNode;
        } else {
            ListNode curr = sortedHead;
            
            while (curr.next != null && curr.next.val < newNode.val) {
                curr = curr.next;

            }
                newNode.next = curr.next;
                curr.next = newNode;
        }
        return sortedHead;
    }
}
