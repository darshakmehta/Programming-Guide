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
        
		ListNode slow = head;
		ListNode fast = head;

		//find collision
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) //collide
				break;
		}

		//No meeting point, no loop
		if(fast == null || fast.next == null) {
			return false;
		}

		//find loop start
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return true;
    }
}