static int calSize(SinglyLinkedListNode head) {
    int size = 0;
    SinglyLinkedListNode current = head;
    while(current != null) {
        current = current.next;
        size++;
    }
    return size;
}
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    int size1 = calSize(head1);
    int size2 = calSize(head2);
    SinglyLinkedListNode temp1 = head1;
    SinglyLinkedListNode temp2 = head2;
    if(size1 > size2) {
        for(int i = 0; i < (Math.abs(size1 - size2)); i++) {
            temp1 = temp1.next;
        }
    } else {
        for(int i = 0; i < (Math.abs(size1 - size2)); i++) {
            temp2 = temp2.next;
        }
    }
    
    while(temp1 != temp2) {
        temp1 = temp1.next;
        temp2 = temp2.next;
    }
    return temp1.data;
}