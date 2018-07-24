import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stackMax = new Stack<Integer>();
        stackMax.push(Integer.MIN_VALUE);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String a[] = s.split(" ");
            
            if(a[0].equals("1")) {
                stack.push(Integer.parseInt(a[1]));
                if(stack.peek() >= stackMax.peek()) {  //Important to stack multiple max elements
                    stackMax.push(stack.peek());
                }
            } else if(a[0].equals("2")) {
                if(stackMax.peek() == stack.peek()) {
                    stackMax.pop();
                }
                stack.pop();
            } else if(a[0].equals("3")) {
                System.out.println(stackMax.peek());
            }
          }
    }
}
