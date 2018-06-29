import java.util.*;
import java.lang.*;
import java.io.*;

class LinkedList
{
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		} 
	}
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	 
	public void push(int data) { //O(1)
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return;
	}
	
	public void insertAfter(Node prev_node, int data) { //O(1)
		if(prev_node == null)
			return;
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}
	
	public void append(int data) { //O(n)
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node n = head;
		while( n.next != null) {
			n = n.next;
		}
		n.next = new_node;
		return;
	}
	
	public void delete(int key) {
		Node temp = head;
		Node prev = null;
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while(temp !=null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null)
			return;
		prev.next = temp.next;
		
	}
	public void deleteNode(int position) {

		//LinkedList is empty 
		if( head == null)
			return;
		Node temp = head;
		if(position == 0) {
			head = temp.next;
			return;
		}

		for(int i = 0; temp!=null && i < position - 1; i++ )
			temp = temp.next;

		if(temp == null || temp.next == null)
			return;

		temp.next = temp.next.next;
		
	}
	
	public int countRecursive(Node head) {
		if(head == null)
			return 0;
		return 1 + countRecursive(head.next);
		
	}
	
	public int countIter() {
		Node n = head;
		int count = 0;
		while(n != null) {
			count++;
			n = n.next;
		}
		return count;
	}
	
	public int count() {
		return countRecursive(head);
	}

	class Result {
		Node tail;
		int size;
		Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public Result getTailAndSize(Node node) {
		if(node == null) return null;
		int size = 1;
		Node current = node;
		while(current.next!= null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	public Node getKthNode(Node head, int k) {
		Node current = head;
		for( int i = 0; current != null && i < k; i++) {
			current = current.next;
		}
		return current;
	}

	public Node getIntersection(Node first, Node second) {
		if(first == null || second == null) return null;

		Result result1 = getTailAndSize(first);
		Result result2 = getTailAndSize(second);

		if(result1.tail != result2.tail)
			return null;
		Node shorter = result1.size > result2.size ? second : first;
		Node longer = result1.size > result2.size ? first : second;

		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		return longer; //or return shorter;

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		LinkedList firstLinkedList = new LinkedList();
		linkedList.append(0);
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);
		LinkedList secondLinkedList = new LinkedList();
		linkedList.append(10);
		linkedList.append(9);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(6);

		System.out.println(firstLinkedList.getIntersection(firstLinkedList.head, secondLinkedList.head));
		
	}
}
