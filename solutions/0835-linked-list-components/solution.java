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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hash=new HashSet<>();
        for(int num:nums){
            hash.add(num);
        }
        int set=0,count=0;
        ListNode temp=head;
        while(temp!=null){
            if(hash.contains(temp.val)){
                set=1;
            } else if(set==1){
                count++;
                set=0;
            }
            temp=temp.next;
        }
        return set==1?count+1:count;
    }
}
