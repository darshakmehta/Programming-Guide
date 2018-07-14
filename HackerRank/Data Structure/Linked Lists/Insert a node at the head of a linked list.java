static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode temp = llist;
        if(temp == null) {
            SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
            temp = new_node;
            return temp;
        }
        
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
        new_node.next = temp;
        return new_node;
        

}