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

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int key) {
		if(top == null) {
			Node new_node = new Node(key);
			top = new_node;
			new_node.next = null;
			return;
		}
		Node new_node = new Node(key);
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

	public static void main (String[] args) throws java.lang.Exception
	{
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);

		int x = s.pop();
		System.out.println(s.peek());
	}
}