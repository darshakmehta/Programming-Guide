/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static long gcd(long a, long b) {
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    }
    
    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while ( t-- != 0 ) {
                long n = sc.nextLong();
                long a = sc.nextLong();
                long b = sc.nextLong();
                long k = sc.nextLong();
                if( a == b ) {
                    System.out.println("Lose");
                    continue;
                }
            
                long x = (n / a);
                long y = (n / b);
                long z = (n / lcm(a, b));
                
                if ( (x + y - (2 * z) ) >= k) {
                    System.out.println("Win");
                } else {
                    System.out.println("Lose");
                }
            }
        } catch ( Exception e ) {
            
        }
        
    }
}