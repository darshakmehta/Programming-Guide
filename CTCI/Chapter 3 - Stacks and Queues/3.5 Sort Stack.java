import java.util.*;
import java.lang.*;
import java.io.*;

class SortStack<T>  //<T> Generics 
{
	public void sortStack(Stack<Integer> s) { //O(n^2) solution and O(n) space
 		Stack<Integer> temp = new Stack<Integer>();

 		if(s.isEmpty())
 			return;
 		while(!s.isEmpty()) {
 			int x = s.pop();
	 		while(!temp.isEmpty() && (temp.peek() > x)) {
	 			s.push(temp.pop());
	 		}
	 		temp.push(x);	
 		}
 		while(!temp.isEmpty()) {
 			s.push(temp.pop());
 		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(7);
		stack.push(8);
		stack.push(12);
		stack.push(19);
		stack.push(21);
		stack.push(3);
		new SortStack().sortStack(stack);
		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
}



/***

TODO: 

1. Sort using Merge Sort 
2. Sort using Quick Sort

***/