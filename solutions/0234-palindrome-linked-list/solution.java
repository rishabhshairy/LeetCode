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
    public boolean isPalindrome(ListNode head) {
    ListNode newHead = reverseNew(head);
  ListNode p1 = head;
  ListNode p2 = newHead;
  while (p1 != null) {
    if (p1.val != p2.val) return false;
    p1 = p1.next;
    p2 = p2.next;
  }
  return true;
}

// iteration
private ListNode reverseNew(ListNode head) {
  if (head == null) {
    return head;
  }
  ListNode dummy = new ListNode(0);
  dummy.next = null;
  ListNode p = head;
  while (p != null) { // addFirst
    ListNode newNode = new ListNode(p.val);
    newNode.next = dummy.next;
    dummy.next = newNode;
    p = p.next;
  }
  return dummy.next;
    }
}
