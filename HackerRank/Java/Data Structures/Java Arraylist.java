import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int q = sc.nextInt();
        String s = sc.nextLine();
        for(int i = 0; i < q; i++) {
            s = sc.next();
            if(s.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
            } else if(s.equals("Delete")) {
                int x = sc.nextInt();
                list.remove(x);
            }
        }
        
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

/***

Use of LinkedList will increase the speed, as ArrayList is slower 

***/