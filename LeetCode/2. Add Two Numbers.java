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


/***

Follow up

What if the the digits in the linked list are stored in non-reversed order? For example:

(3 → 4 → 2) + (4 → 6 → 5) = 8 → 0 → 7

***/

/* Another Solution */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head_newList = null;
        ListNode prev = null, node = null;
        while(l1 != null && l2 != null) {
            int x = l1.val + l2.val;
            node = new ListNode((x + carry) % 10 );
            if ( (x + carry) >= 10 ) {
                carry = 1;
            } else {
                carry = 0;
            }
            if( head_newList == null ) {
                head_newList = node;
            } else {
                prev.next = node;
            }
            prev = node;  
            l1 = l1.next;
            l2 = l2.next;   
        }
        
        while(l1 != null) {
            node = new ListNode((l1.val + carry) % 10);
            prev.next = node;
            prev = node;
            if((l1.val + carry) >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1.next;
        } 
        
        while(l2 != null) {
            node = new ListNode((l2.val + carry) % 10);
            prev.next = node;
            prev = node;
            if((l2.val + carry) >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            l2 = l2.next;
        } 
        
        if( carry == 1) {
            node = new ListNode(1);
            prev.next = node;
        }
        return head_newList;
    }
}