import java.util.*;
import java.lang.*;
import java.io.*;

class LinkedList
{
	Node head;
	
	static class Node {
		Node next;
		int data;
		
		Node(int data) {
			this.next = null;
			this.data = data;
		} 
	}
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	 
	public void push(int data) { // O(1)
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		return;
	}
	
	public void insertAfter(Node prev_node, int data) { // O(1)
		if ( prev_node == null ) return;
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}
	
	public void append(int data) { // O(n)
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			return;
		}
		Node n = head;
		while ( n.next != null ) {
			n = n.next;
		}
		n.next = new_node;
		return;
	}
	
	public void delete(int key) {
		Node temp = head;
		Node prev = null;
		if( temp != null && temp.data == key ) {
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

	/* Function deletes the entire linked list */
	//In Java, automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to null.
    public void deleteList() {
        head = null;
    }

	public boolean searchIterative(int key) {
		Node current = head;
		while(current != null) {
			if(current.data == key )
				return true;
			current = current.next;
		}
		return false;
	}
	
	public boolean searchRecursive(Node head, int key) {
		if(head == null)
			return false;
		if(head.data == key)
			return true;
		else
			return searchRecursive(head.next, key);
	}
	
	public void removeDuplicates() { //O(n)
		Node current = head;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		Node prev = null;
		while(current != null) {
			if(hmap.containsKey(current.data)) {
				prev.next = current.next;
			} else {
				hmap.put(current.data, 1);
				prev = current;
				
			}
			current = current.next;
		}
	}

	public void removeDuplicatesSortedList() { // O(n)
		Node current = head;
		Node next = null;
		while(current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}	

	public void removeDuplicatesNoBuffer() { // O(1) space but O(n^2) time
		Node current = head;
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(current.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	// O(n) time and O(1) space
	public Node kthToLastElements(int k) { // kth element from last [k = 1 --> last element]
		Node p1 = head;
		Node p2 = head;
		//Place p1 k nodes in the list and p2 in the beginning
		for ( int i = 0; i < k; i++ ) {
			if ( p1 == null ) return null;
			p1 = p1.next;
		}
		while ( p1 != null ) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main (String[] args) throws java.lang.Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.append(3);
		linkedList.append(3);
		linkedList.append(3);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(4);
		linkedList.append(4);
		linkedList.append(4);
		linkedList.append(5);
		linkedList.append(5);
		linkedList.append(7);
		linkedList.append(8);
		linkedList.removeDuplicates();
		//linkedList.removeDuplicatesSortedList();
		//linkedList.removeDuplicatesNoBuffer();
		//linkedList.printList();
		linkedList.kthToLastElements(2);
		
	}
}

/*** TODO: Recursive approach ***/

/** 

Logic:

Assume: Consider there are 10 elements (i.e. n = 10) and we are finding 4th last element (i.e. k = 4)
Goal: we desire to reach at ( n - k ) i.e. (10 - 4) i.e 6th element

Now, we will go 4 steps (reference pointer) ahead from head node. 

Further, lets traverse again the reference pointer until end of linkedlist (from 5th to 10th element). 
But this time, we will have (main pointer) traversing from head until reference pointer will reach at the end of the linkedlist.

This, way reference pointer will traverse (5th to 10th element) and p2 will traverse (1st to 6th element). 
And Our answer will be the last position of the main pointer

*/