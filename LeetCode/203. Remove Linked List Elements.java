/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode cur = head;
        ListNode prev = null;
        
        while(cur != null) {
            if(cur.val == val) {
                if(prev == null) {
                    head = cur.next;
                    prev = null;
                } else {
                    prev.next = cur.next;
                }
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;    
            }
        }
        
        return head;
    }
}