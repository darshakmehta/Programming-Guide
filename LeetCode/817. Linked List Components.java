/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<Integer>();
        
        for ( int n : G ) {
            set.add(n);
        }
        
        int count = 0;
        int result = 0;
        
        while (head != null) {
            if ( !set.contains(head.val) ) {
                if ( count != 0 ) {
                    result++;
                    count = 0;
                }
            } else {
                count++;
            }
            head = head.next;
        }
        
        if (count != 0)
            result++;
        
        return result;
    }
}