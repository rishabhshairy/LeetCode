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
        ListNode less = new ListNode(0);
		ListNode lessDummy = less;

		ListNode more = new ListNode(0);
		ListNode moreDummy = more;

		ListNode temp = head;
		while (temp != null) {
			
			// create a node for memory adjustment
			ListNode node = temp; 
			if (temp.val < x) {
				lessDummy.next = node;
				lessDummy = lessDummy.next;
			} else {
				moreDummy.next = node;
				moreDummy = moreDummy.next;
			}
			temp = temp.next;
			node.next = null;
		}
		lessDummy.next = more.next;
		return less.next;
    }
}
