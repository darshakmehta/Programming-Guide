static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2)     {
    SinglyLinkedListNode temp1 = head1;
    SinglyLinkedListNode temp2 = head2;
    SinglyLinkedListNode prev = null;
    while(temp2 != null && temp1 != null) {
        
        if(temp2.data < temp1.data) {
            head2 = temp2.next;
            temp2.next = temp1;
            if(temp1 == head1) {
                head1 = temp2;
            } else {
                prev.next = temp2;
            }
            temp2 = head2;
            temp1 = head1;
        } else {
            prev = temp1;
            temp1 = temp1.next;
        }
    }
    if(temp2 != null) {
        prev.next = temp2;
    }

    return head1;
}