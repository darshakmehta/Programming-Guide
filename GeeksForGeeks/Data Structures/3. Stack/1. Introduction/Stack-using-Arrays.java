import java.util.*;
import java.lang.*;
import java.io.*;

// Implementation using Arrays
class Stack
{
	static final int MAX = Integer.MAX_VALUE;
	int top;
	int[] a = new int[MAX];

	Stack() {
		top = -1;
	}

	public void push(int key) {
		if (top >= MAX - 1) {
			// Overflow
		} else {
			a[++top] = key;
		}
	}

	public int pop() {
		if (top < 0) {
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
		if (top < 0) {
			// underflow
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

// Pros: Easy to implement. Memory is saved as pointers are not involved.
// Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.

/***

Applications of stack:

Balancing of symbols
Infix to Postfix /Prefix conversion
Redo-undo features at many places like editors, photoshop.
Forward and backward feature in web browsers
Used in many algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.
Other applications can be Backtracking, Knight tour problem, rat in a maze, N queen problem and sudoku solver
In Graph Algorithms like Topological Sorting and Strongly Connected Components

**/
