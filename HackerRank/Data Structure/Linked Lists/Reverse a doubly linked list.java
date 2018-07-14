//Swap data : Similar process to reversing an array or string. Running time is O(n)
static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode start = head;
    DoublyLinkedListNode end = head;
    while(end.next != null) {
        end = end.next;
    }

    while(start != end) {
        int temp = start.data;
        start.data = end.data;
        end.data = temp;
        start = start.next;
        if(start == end)
            break;
        end = end.prev;
    }

    return head;
}

//Note: Swapping data can be costly compared to pointers if size of data item(s) is more.

//Swap Nodes :  Running time is O(n)
static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode current = head;
    DoublyLinkedListNode temp = null;
    while(current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }
    if(temp != null) {
        head = temp.prev;    
    }
    return head;
}