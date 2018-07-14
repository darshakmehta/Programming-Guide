static void reversePrint(SinglyLinkedListNode head) {
    Stack<Integer> stack = new Stack<Integer>();
    
    while(head != null) {
        stack.push(head.data);
        head = head.next;
    }
    while(!stack.isEmpty()) {
        System.out.println(stack.pop());
    }

}

/***

TODO:

1. Recursive function


***/