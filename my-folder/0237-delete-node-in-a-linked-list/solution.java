/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=0;
        node.val += node.next.val;
        node.next=node.next.next;
     //   System.out.print(node.next.val);
    }
}
