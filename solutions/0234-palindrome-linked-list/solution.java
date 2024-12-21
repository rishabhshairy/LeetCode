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
        Stack<Integer> nodeStack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            nodeStack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!nodeStack.isEmpty()) {
            if (nodeStack.pop() == temp.val) {
                temp = temp.next;
            } else {
                return false;
            }
        }
        return nodeStack.isEmpty();
    }
}
