/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

/***

Consider 
List 1 = 5 elements; Intersection node is at 3rd element
List 2 = 6 elements; Intersection node is at 4th element

Now, loop first list and than start looping second list;
Now, loop second list and than start looping first list;

Therefore List 1 = 5 + 6 (list 2) = 11 elements [first touch at intersection on 3rd and 9th]
Therefore List 2 = 6 + 5 (list 1) = 11 elements [first touch at intersection on 4th and 9th]

So, if there is intersection point between 2 list, it will be met on 9th position.

Beautiful Math property

***/