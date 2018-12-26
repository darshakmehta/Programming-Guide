/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //O(n^2)
    public void reorderList(ListNode head) {
        if(head == null) return;
        
        ListNode root = head;
        ListNode second = head.next;
        ListNode first = head;
        ListNode prev = null;
        
        while ( first != null && first.next != null ) {
            prev = first;
            first = first.next;
            
            if ( first.next == null ) {
                ListNode last = first;
                root.next = last;
                if(last != second) {
                    last.next = second;
                    prev.next = null;
                }
                
                // Reinitialize
                
                first = second;
                second = second.next;
                root = first;
                
            }
        }
    }
}


/**

TODO:

1. Using Stack
2.

Step 1: Find Middle of list using two pointer technique
Step 2: Reverse the other half of the list
Step 3: Merge first half and Step 2

 **/