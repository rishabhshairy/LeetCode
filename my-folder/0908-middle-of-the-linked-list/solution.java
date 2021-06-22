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
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode temp=head;
        int len=0;
        
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int mid=(len/2)+1;
        
        temp=head;
        ListNode pre=head;
        while(mid-->0){
            pre=temp;
            temp=temp.next;
        }
        return pre;
    }
}
