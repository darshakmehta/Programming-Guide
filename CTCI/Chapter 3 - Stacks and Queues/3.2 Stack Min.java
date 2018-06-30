import java.util.*;
import java.lang.*;
import java.io.*;

//Implementation using Arrays
class Stack
{
	Node top;

	class Node {
		int data;
		Node next;
		int min;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.min = 999;
		}
	}

	public void push(int key) {
		if(top == null) {
			Node new_node = new Node(key);
			top = new_node;
			new_node.next = null;
			new_node.min = key;
			return;
		}
		Node new_node = new Node(key);
		if(top.min > key) 
			new_node.min = key;	
		else 
			new_node.min = top.min;	
		new_node.next = top;
		top = new_node;
	}

	public int pop() {
		if(top == null)
			return -1; //underflow
		int x = top.data;
		Node temp = top;
		top = top.next;
		return x;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public int peek() {
		if(top == null)
			return -1;
		return top.data;
	}
	
	public int minValue() {
		if(top == null)
			return -1;
		return top.min;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Stack s = new Stack();
		s.push(80);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(10);
		//int x = s.pop();
		System.out.println(s.minValue());
	}
}

/***

TODO: 

1. For large stack, it will be memory inefficient to store min at every node, so we can think of better way, like to have another stack to maintain the minimum value, until it has another minimum value. [Left for implementation]


For example:

Example1: 

Stack1 : 10,20,30,40,50,60,70,80,90 ... so on for 100000 times, so first inserted is the smallest.
Stack2: 10
Therefore, we will track 10 as min in Stack2 instead of havin 10 stored for every node.

Example2:

Stack1: 10,20,30,40,50,1,60,70,80,2
Stack2: 10, 1, 2

Steps for implementation:

1. Create Stack2 class that extends Stack class, setup constructor

2. While pushing, check if value inserted in the stack is less than equal to current min in stack, if it is than push the new value to the Stack2.

3. So pop will check for current value popping out to be equal to the min() if it is, pop it from stack 2... So now we can understand that for values 60,70,80 min will be 1 which is current top value in stack2.

***/