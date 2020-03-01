/**
 * Given an expression string exp , write a program to examine whether the pairsand the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * <p>
 * Example:
 * <p>
 * Input: exp = “[()]{}{[()()]()}”
 * Output: Balanced
 * <p>
 * Input: exp = “[(])”
 * Output: Not Balanced
 * <p>
 * Algorithm:
 * <p>
 * Declare a character stack S.
 * Now traverse the expression string exp.
 * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
 * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and
 * If the popped character is the matching starting bracket then fine else parenthesis are not balanced.
 * After complete traversal, if there is some starting bracket left in stack then “not balanced”
 * Time Complexity: O(n)
 * Auxiliary Space: O(n) for stack.
 * CODE: https://ideone.com/IVALCL
 */

import java.lang.*;
import java.util.*;
import java.io.*;

class BalancedParantheses {
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();

    char[] ch = s.toCharArray();
    for (char c : ch) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          if (c == ')' && stack.peek() == '(') {
            stack.pop();
          } else if (c == '}' && stack.peek() == '{') {
            stack.pop();
          } else if (c == ']' && stack.peek() == '[') {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }

    if (!stack.isEmpty())
      return false;
    return true;
  }

  public static void main(String[] arg) {
    String exp = "{[]}";
    if (isValid(exp))
      System.out.println("Balanced ");
    else
      System.out.println("Not Balanced ");
  }
}
