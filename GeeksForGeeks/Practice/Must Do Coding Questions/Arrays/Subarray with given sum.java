import java.lang.*;
import java.io.*;
import java.util.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t != 0) {
		    int n = sc.nextInt();
		    int target = sc.nextInt();
		    int[] a = new int[n];
		    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		   
		    for(int i = 0; i < n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    int curr_sum = 0, start = 0, end = -1;
		    
		    for(int i = 0; i < n; i++) { //O(n)
		        curr_sum += a[i];
		        
		        if(curr_sum - target == 0) {
		            start = 0; 
		            end = i;
		            break;
		        }
		        
		        if(hmap.containsKey(curr_sum - target)) {
		            start = hmap.get(curr_sum - target) + 1;
		            end = i;
		            break;
		        }
		        
		        hmap.put(curr_sum, i);
		    }
		    if(end == -1)
		           System.out.println("-1");
		    else 
		        System.out.println((start + 1)  + " " + (end + 1));
		    
		    
		    t--;
		}
	}
}