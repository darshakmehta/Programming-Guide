import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void swap(int[] a, int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Faster way to read input
		int t = Integer.parseInt(br.readLine());
		
		while(t != 0) {
		    int n = Integer.parseInt(br.readLine());
		    int[] a = new int[n];
		    
		    String[] arr = br.readLine().split(" "); //Faster way to read Input
		    for(int i = 0; i < n; i++) {
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    
		    int start = 0, end = n - 1;
		    
		    for(int i = start; i <= end; )  {
		        if(a[i] == 0) {
		           if(start != i)
		                swap(a, start, i);
		            start++;
		            i++;
		        } else if(a[i] == 2) {
		           if(end != i)
		                swap(a, i, end);
		            end--;
		        } else {
		            i++;
		        }
		    }
		    
		    StringBuffer sb = new StringBuffer(); //Faster way to output
		    for(int el : a)
		        sb.append(el + " ");
		    System.out.println(sb.toString());
		    
		    t--;
		}
	}
}

/**

http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/

**/