import java.lang.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
       int t, n;
       long x;
       Scanner sc = new Scanner(System.in);
       t = sc.nextInt();
       while(t != 0) {
           n = sc.nextInt();
           x = sc.nextLong();
           long a[] = new long[n];
           for(int i = 0; i < n; i++) {
               a[i] = sc.nextLong();
           }
           Arrays.sort(a);
           int count = 0;
           int remainingToFill = 0;
           for(int i = 0; i < n; i++) {
               if(a[i] <= x && (remainingToFill + a[i]) <= x) {
                   remainingToFill+= a[i];
                   count++;
               } 
           }
            System.out.println(count);
           t--;
       }

    }
}
