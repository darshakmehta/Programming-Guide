import java.util.*;
import java.lang.*;
import java.io.*;

class GFG { //O(1) space and O(n) time
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t != 0) {
		    int n = sc.nextInt();
		    
		    int sum = ( ( n * (n + 1) ) / 2);
		    for(int i = 0; i < n - 1; i++) {
		        int x = sc.nextInt();
		        sum -= x;
		    }
		    
		    System.out.println(sum);
		    
		    t--;
		}
	}
}