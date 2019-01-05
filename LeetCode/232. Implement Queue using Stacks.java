/* Enqueue Operation is Costly */

class MyQueue {
    Stack<Integer> stack1, stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
           while( !stack1.isEmpty() ) {
               stack2.push(stack1.pop());
           }
           stack1.push(x);
            while( !stack2.isEmpty() ) {
                   stack1.push(stack2.pop());
            }    
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/* Dequeue operation is costly */

class MyQueue {
    Stack<Integer> stack1, stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
           stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( stack2.isEmpty() ) {
            while( !stack1.isEmpty() ) 
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if( stack2.isEmpty() ) {
            while( !stack1.isEmpty() ) 
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */