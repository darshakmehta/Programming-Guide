/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { //Does not work for large numbers, alternative use String or follow another solution below
    public ListNode addTwoNumbers(ListNode first, ListNode second) {
        ListNode current1 = first;
		ListNode current2 = second;
		int index = 1;
		int number1 = 0;
		int number2 = 0;
		while(current1 != null) {
			number1 += current1.val * index;
			index = index * 10;
			current1 = current1.next;
		}
		index = 1;
		while(current2 != null) {
			number2 += current2.val * index;
			index = index * 10;
			current2 = current2.next;
		}
		int n = number1 + number2; 
		ListNode head = null;
		while(n != 0) {
			ListNode new_node = new ListNode(n % 10);
			if(head == null) {
				head = new_node;
			} else {
				ListNode node = head;
				while(node.next != null) {
					node = node.next;
				}
				node.next = new_node;
			}
			n = n / 10;
		}
		return head;
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode first = l1;
        ListNode second = l2;
        ListNode current = dummyHead;
        int carry = 0;
        
        while (first != null || second != null) {
            int x = (first != null) ? first.val : 0;
            int y = (second != null) ? second.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}