static int getNode(SinglyLinkedListNode head, int positionFromTail) {
                SinglyLinkedListNode p1 = head;
                SinglyLinkedListNode p2 = head;
                //Place p1 k nodes in the list and p2 in the beginning
                for(int i = 0; i <= positionFromTail; i++)
                    p1 = p1.next;
    
                while(p1 != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p2.data;

    }