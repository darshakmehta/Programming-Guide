import java.lang.*;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
       int n;
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       int s[] = new int[n];
       int c[] = new int[n];
       for(int i = 0; i < n; i++)
            s[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            c[i] = sc.nextInt();
            
        Arrays.sort(s);
        Arrays.sort(c);
        long sum = 0;
        for(int i = 0; i < n; i++)
            sum += (s[i] * c[i]);
       
        System.out.println(sum);
    }
}

/*** 

TODO: Time limit exceeded

1. Try BufferedReader

***/