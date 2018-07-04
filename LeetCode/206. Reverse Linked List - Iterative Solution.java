/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //Correct and inefficient
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode reverse = null;
        
        //Iteratively
        while(current != null) {
            ListNode node = new ListNode(current.val);
            node.next = reverse;
            reverse = node;
            current = current.next;
        }
        
        return reverse;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //Correct and efficient
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode reverse = null;
        ListNode node = null;
        
        //Iteratively
        while(current != null) {
            node = current;
            current = current.next;
            node.next = reverse;
            reverse = node;      
        }
        
        return reverse;
    }
}