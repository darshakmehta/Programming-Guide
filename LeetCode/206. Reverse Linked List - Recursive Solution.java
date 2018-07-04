
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode reverseList(ListNode head, ListNode reverse) {
        if(head == null)
            return reverse;
        //Recursive
        ListNode node = head;
        head = node.next;
        node.next = reverse;
        reverse = node;
        return reverseList(head, reverse);
    }
    
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
}