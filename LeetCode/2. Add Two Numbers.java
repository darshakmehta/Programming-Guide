/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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