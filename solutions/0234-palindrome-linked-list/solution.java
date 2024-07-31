/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int len = 0;
        List<String> listBuilder = new ArrayList<>();
        while (head != null) {
            len++;
            if (head.val != -1) {
                listBuilder.add(String.valueOf(head.val));
            }
            head = head.next;
        }

        if (len == 1) {
            return true;
        }

        int start = 0;
        int end = listBuilder.size() - 1;
        while (start <= end) {
            if (!listBuilder.get(start++).equals(listBuilder.get(end--))) {
                return false;
            }
        }

        return true;
    }
}
