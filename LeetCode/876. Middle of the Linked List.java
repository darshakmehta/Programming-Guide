/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode first = head;
        ListNode second = head.next;
        ListNode result = first;
        while(second != null) {
            if(second.next != null) {
                first = first.next;
                second = second.next.next;
                result = first;
            } else {
                result = first.next;
                break;
            }
        }
        return result;
    }
}