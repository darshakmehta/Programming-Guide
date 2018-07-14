static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode temp = head;
    if(temp == null){
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
        return new_node;
    }
    int count = 0;
    SinglyLinkedListNode prev = null;
    while(temp != null && count != position) {
        prev = temp;
        temp = temp.next;
        count++;
    }
    SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
    new_node.next = temp;
    if(prev != null) {
        prev.next = new_node;
    } else {
        head = new_node;
    }
    
    return head;

}