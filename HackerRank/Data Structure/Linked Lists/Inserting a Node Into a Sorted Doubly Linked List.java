static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode current = head;
    DoublyLinkedListNode new_node = new DoublyLinkedListNode(data);
    if(current == null) {
        head = new_node;
        return head;
    }
    while(current.data < data) {
        if(current.next != null)
            current = current.next;
        else
            break;
    }
    if(current == head) {
        head = new_node;
        new_node.prev = current.prev;
        new_node.next = current;    
    } else if(current.next != null || current.data > data) {
        current.prev.next = new_node;
        new_node.prev = current.prev;
        new_node.next = current;    
    } else {
        new_node.prev = current;
        current.next = new_node;
    }          
    return head;
}