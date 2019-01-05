// Solution 1 -  Memory inefficient

class MinStack {
    
    Node top;
    
    class Node {
        
        Node next;
        int min;
        int data;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.min = Integer.MAX_VALUE;
        }
    }
    
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
    }
    
    public void push(int x) {
        Node new_node = new Node(x);
        if(top == null) {
            top = new_node;   
            //top.min = x;
        }
        System.out.println(top.min + " " + x);
        new_node.min = Math.min(top.min, x);
        new_node.next = top;
        top = new_node;
    }
    
    public void pop() {
        if(top == null)
            return;
        top.min = Integer.MAX_VALUE;
        top = top.next;
        
    }
    
    public int top() {
        if(top == null)
            return -1;
        return top.data;
    }
    
    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
}

/***

TODO: Using 2 stack, as saving one data field on each node, will take large space. We can have second stack where we keep track of min.
Refer CTCI/Chapter 3 - Stacks and Queues/3.2 Stack Min.java

***/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Solution 2

/* Using Two Stack */

class MinStack {
    
    Stack<Integer> stack, minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if( minStack.isEmpty() ) {
            minStack.push(x);
        } else if ( stack.peek() <= minStack.peek()) {
            minStack.push(stack.peek());
        }
    }
    
    public void pop() {
        if( stack.peek().equals(minStack.peek() )) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */