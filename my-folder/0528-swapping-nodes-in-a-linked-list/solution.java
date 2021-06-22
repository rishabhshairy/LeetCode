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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode t=head;
        int len=0;
        while(t!=null){
            len++;
            t=t.next;
        }
        int travel=len-k;
        
        ListNode nb=null;
        ListNode ne=null;
        
        t=head;
        
        while(true){
            if(k==1){
                nb=t;
                break;
            }
            
            k--;
            t=t.next;
        }
        t=head;
        
        while(travel-->0){
            t=t.next;
        }
        
        ne=t;

        int swap=nb.val;
        nb.val=ne.val;
        ne.val=swap;
        
        return head;
    }
}
