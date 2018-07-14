boolean hasCycle(Node head) {
    if(head == null)
        return false;
    Node first = head;
    Node second = head.next;
    while(first != null || second != null) {
        first = first.next;
        if(second.next != null)
            second = second.next.next;
        else
            break;
        if(first == second)
            return true;
    }
    return false;
}