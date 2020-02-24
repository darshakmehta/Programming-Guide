/***
Infix : An expression is called the Infix expression if the operator appears in between the operands in the expression. Simply of the form (operand1 operator operand2).
Example : (A+B) * (C-D)

Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands. Simply of the form (operator operand1 operand2).
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Given a Prefix expression, convert it into a Infix expression.
Computers usually does the computation in either prefix or postfix (usually postfix). But for humans, its easier to understand an Infix expression rather than a prefix. Hence conversion is need for human understanding.



Examples:

Input :  Prefix :  *+AB-CD
Output : Infix : ((A+B)*(C-D))

Input :  Prefix :  *-A/BC-/AKL
Output : Infix : ((A-(B/C))*((A/K)-L))

Algorithm for Prefix to Infix:

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator between them.
string = (operand1 + operator + operand2)
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.

**/

// Code: https://ideone.com/PlfO0T

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	private static boolean isOperator(Character c) {
		switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
				return true;
		}
		return false;
	}
	
	public static String prefixToInfix(String exp) {
		Stack<String> stack = new Stack<String>();
		
		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);
			
			if (isOperator(c)) {
				String s1 = stack.pop();
				String s2 = stack.pop();
				
				String temp = "(" + s1 + String.valueOf(c) + s2 + ")";
				stack.push(temp);
			} else {
				stack.push(String.valueOf(c));
			}
		}
		
		return stack.peek();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String exp = "*-A/BC-/AKL"; 
        System.out.println(prefixToInfix(exp));
	}
}

