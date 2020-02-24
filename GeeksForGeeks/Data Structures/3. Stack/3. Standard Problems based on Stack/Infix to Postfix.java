/***

Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.

Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it.
…..3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis.
6. Repeat steps 2-6 until infix expression is scanned.
7. Print the output
8. Pop and output from the stack until it is not empty.

**/

// Code: https://ideone.com/VlQEav
	
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	
	private static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
    
	public static String infixToPostfix(String exp) {
		String result = new String("");
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";	
				} else {
					stack.pop();
				}
			} else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					if (stack.peek() == '(') {
						return "Invalid Expression";
					}
					result += stack.pop();
				}
				stack.push(c);
			}
			
			while (!stack.isEmpty()) {
				if (stack.peek() == '(') {
					return "Invalid Expression";
				}
				result += stack.pop();
			}
		}
		return result;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp));
	}
}
