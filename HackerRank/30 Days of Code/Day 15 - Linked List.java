public static  Node insert(Node head,int data) {
    //Complete this method
    Node new_node = new Node(data);        
    if(head == null) {
        head = new_node;
        return head;
    }
    Node current = head;
    while(current.next != null) {
        current = current.next;
    }
    current.next = new_node;
    return head;
}