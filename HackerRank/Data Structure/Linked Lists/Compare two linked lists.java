static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    boolean flag = true;
    while(head1 != null && head2 != null) {
        if(!(head1.data == head2.data)) {
            flag = false;
            break;
        }
        head1 = head1.next;
        head2 = head2.next;
        if((head1 != null && head2 == null) || (head2 != null && head1 == null)) {
            flag = false;
            break;
        }
    }
    
    return flag;
}

/***

Running time: O(n - m)
Difference of the list, if n != m
else O(n)

***/