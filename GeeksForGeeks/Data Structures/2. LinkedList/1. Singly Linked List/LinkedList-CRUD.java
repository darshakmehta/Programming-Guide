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
		while (n != null) {
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
		if (prev_node == null) return;
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}
	
	public void append(int data) { //O(n)
		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			return;
		}
		new_node.next = null;
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new_node;
		return;
	}
	
	public void delete(int key) {
		Node temp = head;
		Node prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) return;
		prev.next = temp.next;	
	}
	
	public void deleteNode(int position) {

		//LinkedList is empty 
		if (head == null)
			return;
		Node temp = head;
		if (position == 0) {
			head = temp.next;
			return;
		}

		for (int i = 0; temp != null && i < position - 1; i++ )
			temp = temp.next;

		if (temp == null || temp.next == null)
			return;

		temp.next = temp.next.next;
	}
	
	public int countRecursive(Node head) {
		if (head == null)
			return 0;
		return 1 + countRecursive(head.next);
	}
	
	public int countIter() {
		Node n = head;
		int count = 0;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;
	}
	
	public int count() {
		return countRecursive(head);
	}

	/* Function deletes the entire linked list */
	//In Java, automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to null.
    public void deleteList() {
        head = null;
    }

	public boolean searchIterative(int key) {
		Node current = head;
		while(current != null) {
			if (current.data == key )
				return true;
			current = current.next;
		}
		return false;
	}
	
	public boolean searchRecursive(Node head, int key) {
		if (head == null) return false;
		if (head.data == key) return true;
		else
			return searchRecursive( head.next, key );
	}

	public static void main (String[] args) throws java.lang.Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		linkedList.head.next = second;
		second.next = third;
		
		linkedList.push(4);
		linkedList.insertAfter(second,5);
		linkedList.append(6);
		linkedList.delete(4);
		linkedList.deleteNode(3);
		linkedList.printList();
		System.out.println(linkedList.searchIterative(4));
		System.out.println(linkedList.searchRecursive(linkedList.head, 3));
		//System.out.println(linkedList.countIter());
		//System.out.println(linkedList.count());
	}
}