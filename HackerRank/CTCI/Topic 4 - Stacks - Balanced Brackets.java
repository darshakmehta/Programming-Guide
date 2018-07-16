import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        while (t-- != 0) {
            String input=scanner.nextLine();
            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if(!stack.isEmpty()) {
                        if(c == '}') {
                        if(stack.peek() != '{')
                            break;
                        else
                            stack.pop();
                        } else if(c == ']') {
                            if(stack.peek() != '[') 
                                break;
                            else 
                                stack.pop();
                        } else if(c == ')') {
                            if(stack.peek() != '(')
                                break;
                            else
                                stack.pop();
                        }
                    } else {
                        stack.push(c);
                        break;
                    }
                }
            }
            if(stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scanner.close();
    }
}
