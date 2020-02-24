/***

Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands. Simply of the form (operand1 operand2 operator).
Example : AB+CD-* (Infix : (A+B) * (C-D) )

Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands. Simply of the form (operator operand1 operand2).
Example : *+AB-CD (Infix : (A+B) * (C-D) )

Conversion of Postfix expression directly to Prefix without going through the process of converting them first to Infix and then to Prefix is much better in terms of computation and better understanding the expression (Computers evaluate using Postfix expression).

Examples:

Input :  Postfix : AB+CD-*
Output : Prefix :  *+AB-CD
Explanation : Postfix to Infix : (A+B) * (C-D)
              Infix to Prefix :  *+AB-CD

Input :  Postfix : ABC/-AK/L-*
Output : Prefix :  *-A/BC-/AKL
Explanation : Postfix to Infix : ((A-(B/C))*((A/K)-L))
              Infix to Prefix :  *-A/BC-/AKL 

Algorithm for Postfix to Prefix:

Read the Postfix expression from left to right
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator before them.
string = operator + operand2 + operand1
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.

**/

// Code: https://ideone.com/MDVH6N

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
	
	public static String postfixToPrefix(String exp) {
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if (isOperator(c)) {
				String s1 = stack.pop();
				String s2 = stack.pop();
				
				String temp = String.valueOf(c) + s2 + s1;
				stack.push(temp);
			} else {
				stack.push(String.valueOf(c));
			}
		}
		
		return stack.peek();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String exp = "ABC/-AK/L-*";
        System.out.println(postfixToPrefix(exp));
	}
}
