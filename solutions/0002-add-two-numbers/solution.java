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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null){
            return l2;
        }
        
        if(l2==null){
            return l1;
        }
        
        int len1 = size(l1);
        int len2 = size(l2);

        if (len1 > len2) {
            int i = len1 - len2;
            ListNode temp = l2;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (i-- > 0) {
                temp.next = new ListNode(0, null);
                temp = temp.next;
            }
        } else if (len1 < len2) {
            int i = len2 - len1;
            ListNode temp = l1;
            while (temp.next != null) {
                temp = temp.next;
            }
            while (i-- > 0) {
                temp.next = new ListNode(0, null);
                temp = temp.next;
            }
        }
        ListNode tempA = l1;
        ListNode pre = l1;
        ListNode tempB = l2;
        int carry = 0;
        while (tempA != null && tempB != null) {
            int sum = tempA.val + tempB.val + carry;
            if (sum < 10) {
                tempA.val = sum;
                carry = 0;
            } else {
                carry = sum / 10;
                tempA.val = sum % 10;
            }
            pre = tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if (carry == 1) {
            pre.next = new ListNode(carry, null);
        }
        return l1;
    }
        static int size(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}
