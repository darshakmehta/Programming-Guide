//Recusrive - Incorrect Program

static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    if(head  == null)
        return null;
    if(head.next == null) { //Base Case
        return head;
    }
    SinglyLinkedListNode prev = head;
    head = reverse(prev.next);
    head.next = prev;
    prev.next = null;
    return head;
}

//Iterative with O(n) space

static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    Stack<SinglyLinkedListNode> stack = new Stack<SinglyLinkedListNode>();
    
    while(head != null) {
        stack.push(head);
        head = head.next;
    }
    head = stack.pop();
    SinglyLinkedListNode temp = head;
    while(!stack.isEmpty()) {
        SinglyLinkedListNode next = stack.pop();
        temp.next = next;
        temp = next;     
    }
    temp.next = null;
    return head;
}

//Iterative with O(1) space, using runner technique

static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    if(head == null)
        return null;
    SinglyLinkedListNode prev = null;
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode next = current.next; //Runner technique || 2 pointer technique
    
    while(current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
    return head;
}