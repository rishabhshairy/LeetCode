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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int count=1;
        
        ListNode pre=null, next=null;
        
        while(curr!=null && count<=k){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
            count++;
        }
     //   System.out.println(size(next));
        if((size(next)%k==0 || size(next)>k) && next!=null){
            ListNode res=reverseKGroup(next,k);
            head.next=res;
        } else{
            head.next=next;
        }
        return pre;
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
