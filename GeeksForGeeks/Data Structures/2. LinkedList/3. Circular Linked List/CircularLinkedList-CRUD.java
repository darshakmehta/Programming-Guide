import java.util.*;
import java.lang.*;
import java.io.*;

class CircularLinkedList
{

	Node last;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		} 
	}

	public void addToEmpty(int key) {
		if(last != null)
			return;

		Node new_node = new Node(key);
		last = new_node;
		new_node.next = new_node;
	}

	public void addToBegin(int key) {
		if(last == null)
			return;

		Node new_node = new Node(key);
		new_node.next = last.next;
		last.next = new_node;

	}

	public void addToEnd(int key) {
		if(last == null)
			return;

		Node new_node = new Node(key);
		new_node.next = last.next;
		last.next = new_node;
		last = new_node;
	}

	public void addAfter(int key, int after) {
		if(last == null)
			return;
		Node temp = last.next;
		do {
			if(temp.data != after) {
				temp = temp.next;
			} else {
				break;
			}
		} while(temp != last.next);

		Node new_node = new Node(key);
		new_node.next = temp.next;
		temp.next = new_node;
		if(temp == last)
			last = temp;

	}

	public void printList() {
		if(last == null)
			return;
		Node temp = last.next;
		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while(temp != last.next);
	}
	
	public int countNode() {
		Node temp = last.next;
		int count = 0;
		do {
			count++;
			temp = temp.next;
		} while(temp != last.next);
		return count;
	}
	
	public void deleteNode(int key) {
		if(last == null)
			return;
		Node temp = last.next;
		Node prev = null;
		while(temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == last.next) {
			last.next = temp.next;
		} else if(temp == last) {
			last = prev;
			prev.next = temp.next;
			
		} else {
			prev.next = temp.next;
		}
		
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.addToEmpty(1);
		circularLinkedList.addToBegin(2);
		circularLinkedList.addToEnd(3);
		circularLinkedList.addToBegin(5);
		circularLinkedList.addToEnd(9);
		circularLinkedList.addAfter(5, 2);
		circularLinkedList.addAfter(8, 1);
		//circularLinkedList.printList();
		//System.out.println(circularLinkedList.countNode());
		circularLinkedList.deleteNode(5);
		circularLinkedList.deleteNode(5);
		circularLinkedList.deleteNode(9);
		circularLinkedList.printList();
	}
}


/***

TODO:

1. Convert singly linked list into circular linked list O(n)
Answer: 
1. Traverse to the end of the list
2. Assign last node next to head node

***/