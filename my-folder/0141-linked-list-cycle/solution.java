/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp=head;
        
        if(head==null || head.next==null){
            return false;
        }
        
        while(temp!=null && temp.next!=null){
            temp.val=Integer.MAX_VALUE;
            
            
            if(temp.next.val == Integer.MAX_VALUE){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
}
