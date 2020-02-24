/***

Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands. Simply of the form (operator operand1 operand2).
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands. Simply of the form (operand1 operand2 operator).
Example : AB+CD-* (Infix : (A+B * (C-D) )

Conversion of Prefix expression directly to Postfix without going through the process of converting them first to Infix and then to Postfix is much better in terms of computation and better understanding the expression (Computers evaluate using Postfix expression).

Examples:

Input :  Prefix :  *+AB-CD
Output : Postfix : AB+CD-*
Explanation : Prefix to Infix :  (A+B) * (C-D)
              Infix to Postfix :  AB+CD-*

Input :  Prefix :  *-A/BC-/AKL
Output : Postfix : ABC/-AK/L-*
Explanation : Prefix to Infix :  A-(B/C)*(A/K)-L
              Infix to Postfix : ABC/-AK/L-* 

Algorithm for Prefix to Postfix:

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator after them.
string = operand1 + operand2 + operator
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.

**/

// Code: https://ideone.com/hwq4qD

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
	
	public static String prefixToPostfix(String exp) {
		Stack<String> stack = new Stack<String>();
		
		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);
			
			if (isOperator(c)) {
				String s1 = stack.pop();
				String s2 = stack.pop();
				
				String temp = s1 + s2 + String.valueOf(c);
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
        System.out.println(prefixToPostfix(exp));
	}
}
