/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode first = head;
        ListNode prev = null;
        while(first.next != null) {
            size++;
            first = first.next;
        }
        int x = size - n;
        int i = 0;
        first = head;
        if(x == 0) {
            head = first.next;
            return head;
        }
        while(i++ != x) {
            prev = first;
            first = first.next;
        }
        
        prev.next = first.next;
        
        return head;
    }
}