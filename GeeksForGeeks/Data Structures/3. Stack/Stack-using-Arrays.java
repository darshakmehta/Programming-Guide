import java.util.*;
import java.lang.*;
import java.io.*;

//Implementation using Arrays
class Stack
{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	Stack() {
		top = -1;
	}

	public void push(int key) {
		if(top >= MAX-1) {
			//Overflow
		} else {
			a[++top] = key;
		}
	}

	public int pop() {
		if(top < 0) {
			//underflow
		} else {
			return a[top--];
		}
		return -1;
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public int peek() {
		if(top < 0) {
			//underflow
			return -1;
		}
		return a[top];
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