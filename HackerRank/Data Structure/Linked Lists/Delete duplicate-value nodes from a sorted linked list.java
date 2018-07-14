static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if(head == null)
            return null;
        SinglyLinkedListNode first = head;
        SinglyLinkedListNode second = head.next;
        
        while(first != null && second != null) {
            if(first.data == second.data) {
                first.next = second.next;
                second = first.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }