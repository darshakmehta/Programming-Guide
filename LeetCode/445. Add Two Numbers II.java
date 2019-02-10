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
        Stack<Integer> first = new Stack<Integer>();
        Stack<Integer> second = new Stack<Integer>();
        Stack<Integer> result = new Stack<Integer>();
        
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(cur1 != null) {
            first.push(cur1.val);
            cur1 = cur1.next;
        }
        
        while(cur2 != null) {
            second.push(cur2.val);
            cur2 = cur2.next;
        }
        
        int carry = 0;
        
        while ( !first.isEmpty() && !second.isEmpty() ) {
            int x = carry + first.pop() + second.pop();
            carry = x / 10;

            if ( carry == 1 ) {
                result.push(x % 10);
            } else {
                result.push(x);
            }
        }
        
        while ( !first.isEmpty() ) {
            int x = carry + first.pop();
            carry = x / 10;
            
            if ( carry == 1 ) {
                result.push(x % 10);
            } else {
                result.push(x);
            }
        }
        
        while ( !second.isEmpty() ) {
            int x = carry + second.pop();
            carry = x / 10;
            
            if ( carry == 1 ) {
                result.push(x % 10);
            } else {
                result.push(x);
            }
        }
        
        if ( carry == 1 )
            result.push(carry);
            
        ListNode resultHead = null;
        ListNode curr = null;
        
        while ( !result.isEmpty() ) {
            ListNode newnode = new ListNode(result.pop());
            if( curr == null ) {
                resultHead = newnode;
            } else {
                curr.next = newnode;
            }
            curr = newnode;
        }
        
        return resultHead;
    }
}