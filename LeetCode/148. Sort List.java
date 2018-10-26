/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode first = head, second = head;
        ListNode minHead = head;
        while(first != null) {
            boolean flag = false;
            if(first.next != null) {
                second = first.next;
                while(second != null) {
                    if(second.val < minHead.val) {
                        minHead = second;
                        flag = true;
                    }
                    second = second.next;
                }
                    if(flag) {
                        int t = first.val;
                        first.val = minHead.val;
                        minHead.val = t;
                    }
            }
            first = first.next;
            minHead = first;
        }
    
       return head;
    }
}

/***

Above code is O(n^2) solution with O(1) space

TODO: O(nlogn) with O(1) space --> Using Merge Sort Technique

***/