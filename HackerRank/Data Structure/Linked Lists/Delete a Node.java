static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    SinglyLinkedListNode temp = head;
    int count = 0;
    SinglyLinkedListNode prev = null;
    while(temp != null && count != position) {
        prev = temp;
        temp = temp.next;
        count++;
    }
    if(temp == head)
        head = temp.next;
    else
        prev.next = temp.next;
    return head;
}