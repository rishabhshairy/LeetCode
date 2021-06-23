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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode currLess = less;

        ListNode more = new ListNode();
        ListNode currMore = more;


        ListNode temp = head;

        while (temp != null) {
            ListNode node = temp;
            if (node.val < x) {
                currLess.next = node;
                currLess = currLess.next;
            } else {
                currMore.next = node;
                currMore = currMore.next;
            }
            temp=temp.next;
            node.next=null;
        }
        currLess.next = more.next;
        return less.next;
    }
}
