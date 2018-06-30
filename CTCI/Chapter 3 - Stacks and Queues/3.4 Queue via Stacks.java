import java.util.*;
import java.lang.*;
import java.io.*;

class MyQueue<T>  //<T> Generics 
{
	Stack<T> stackNewest;
	Stack<T> stackOldest;
	
	MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public void add(T key) {
		stackNewest.push(key);
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) { 
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek(); // retrieve the oldest item.
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop(); // pop the oldest item.
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		MyQueue queue = new MyQueue();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println(queue.peek());

	}
}



/***

Above Solution: All new items are pushed into stackNewest and we deque from stackOldest. Here deque is costly operation.

Another Solution (Less efficient): Having enQueue as a costly operation by pushing to and from stack1 to stack2 while enqueuing. Dequeue is simple operation where you pop item from stack1


TODO: 

1. Goal: Achieve using single user defined stack, with help of function call (recursion) [Reference: https://www.geeksforgeeks.org/queue-using-stacks/]

***/