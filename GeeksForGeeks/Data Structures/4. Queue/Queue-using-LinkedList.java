import java.util.*;
import java.lang.*;
import java.io.*;

class MyQueue
{
	Node first;
	Node last;
	
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void add(int key) {
		Node new_node = new Node(key);
		if(last == null) {
			last = new_node;
			first = last;
			return;
		}
		last.next = new_node;
		last = new_node;
	}

	public int remove() {
		if(first == null)
			return -1;
		int data = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return data;
	}

	public int peek() {
		if(first == null)
			return -1;
		return first.data;
	}

	public boolean isEmpty() {
		return (first == null);
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