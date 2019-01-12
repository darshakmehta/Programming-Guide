import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Stack<Character> stack = new Stack<Character>();
		StringBuilder result = new StringBuilder();
		
		String s = "<html><head><title></title></head><body></body></html>";
		
		for ( char c : s.toCharArray() ) {
			if ( c == '<' ) {
				stack = new Stack();
			} else if ( c == '>' ) {
				result.append("<");
				while( !stack.isEmpty() ) {
					result.append(stack.pop());
				}
				result.append(">");
			} else {
				stack.push(c);
			}
		}
		
		System.out.println(result.toString());
 	}
}

/**

OUTPUT: <lmth><daeh><eltit><eltit/><daeh/><ydob><ydob/><lmth/>

**/