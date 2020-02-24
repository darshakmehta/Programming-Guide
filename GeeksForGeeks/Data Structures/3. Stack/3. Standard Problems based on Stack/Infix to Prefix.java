/***

Convert Infix To Prefix Notation
While we use infix expressions in our day to day lives. Computers have trouble understanding this format because they need to keep in mind rules of operator precedence and also brackets. Prefix and Postfix expressions are easier for a computer to understand and evaluate.

Given two operands a and b and an operator \odot, the infix notation implies that O will be placed in between a and b i.e  a \odot b . When the operator is placed after both operands i.e ab\odot, it is called postfix notation. And when the operator is placed before the operands i.e  \odot a b, the expression in prefix notation.


Examples:

Input : A * B + C / D
Output : + * A B/ C D 

Input : (A - B/C) * (A/K-L)
Output : *-A/BC-/AKL

Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.

**/

// Code: https://ideone.com/ndQ3Vt

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

	public static String infixToPrefix(String exp) {
		Stack<Character> stack = new Stack<Character>();
		String result = "";
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == ')') {
				stack.push(c);
			} else if (c == '(') {
				while(!stack.isEmpty() && stack.peek() != ')') {
					result += stack.pop();
				}
				
				if (!stack.isEmpty() && stack.peek() == ')') {
					stack.pop();
				}
			} else {
				while (!stack.isEmpty() && Prec(c) < Prec(stack.peek())) {
					result += stack.pop();
				} 
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		
		return new StringBuilder(result).reverse().toString();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String exp = "K+L-M*N+(O^P)*W/U/V*T+Q";
		StringBuilder sb = new StringBuilder(exp);
		sb.reverse();
        System.out.println(infixToPrefix(sb.toString()));
	}
}
