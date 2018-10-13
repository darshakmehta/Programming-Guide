/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode prev = first;
        ListNode temp2 = null;
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        
        
        while(second != null) {
                if(first.val > second.val) {
                        if(first != l1) {
                            temp2 = second.next;
                            prev.next = second;
                            prev = second;
                            second.next = first;
                            second = temp2;
                        } else {
                            second = second.next;
                            l2.next = l1;
                            l1 = l2;
                            first = l1;
                        }
                } else {
                    prev = first;
                    if(first.next != null)
                        first = first.next;  
                    else {
                        prev.next = second;
                        return l1;
                    }
                }
        }
        return l1;
    }
}