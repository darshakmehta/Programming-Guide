static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
            
            SinglyLinkedListNode temp = head;
            if(temp == null){
                SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
                head = new_node;
                return head;
            }    
        
            while(temp.next != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            
            SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
            temp.next = new_node;
        
        return head;

    }