import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t != 0) {
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    
		    for(int i = 0; i < n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    int maxSoFar = a[0];
		    int currMax = a[0];
		    
		    for(int i = 1; i < a.length; i++) {
		        currMax = Math.max(a[i], a[i] + currMax);
		        maxSoFar = Math.max(maxSoFar, currMax);
		    }
		    System.out.println(maxSoFar);
		    
		    
		    t--;
		}
	}
}

/* Print Subarray ELements : https://git.io/fhUPT */