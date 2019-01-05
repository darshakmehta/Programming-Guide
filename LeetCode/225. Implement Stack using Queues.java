/* Expensive Push Operation */
class MyStack {
    
    Queue<Integer> queue1, queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);
        while( !queue1.isEmpty() ) {
            queue2.add( queue1.poll() );
        }
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


/* Expensive Pop Operation */

class MyStack {
    
    Queue<Integer> queue1, queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while( queue1.size() != 1 ) {
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        while( queue1.size() != 1 ) {
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        queue2.add(result);
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */