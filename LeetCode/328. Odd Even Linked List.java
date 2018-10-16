/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode evenList = head.next;
        while(temp1 != null && temp2 != null) {
            if(temp2.next == null) {
                break;
            }
            temp1.next = temp2.next;
            temp2.next = temp1.next.next;
            temp1.next.next = evenList;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return head;
    }
}

/***

Nicer solution

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenList = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenList;
        return head;
    }
}


***/

/***

/***
Not recommended

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        while(temp.next != null)
            temp = temp.next;
        
        ListNode last = temp;
        int index = 1;
        ListNode current = head;
        ListNode prev = head;
        while(current.next != null  && current != last) {
            if(index % 2 == 0) {
                ListNode newnode = new ListNode(current.val);
                temp.next = newnode;
                temp = temp.next;
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
            index++;
        }
        if(index % 2 == 0) {
             ListNode newnode = new ListNode(current.val);
             temp.next = newnode;
             prev.next = current.next;
        }
        return head;
    }
}

***/