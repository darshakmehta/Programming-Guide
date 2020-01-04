import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			
			while ( t-- != 0 ) {
				int n = Integer.parseInt(br.readLine());
			    
				String[] arr = new String[n];
				Set<Character> set = new HashSet<Character>();
				int min = Integer.MAX_VALUE;
			    int index = 0;
			    
				for ( int i = 0; i < n; i++ ) {
					arr[i] = br.readLine();
					if(arr[i].length() < min) {
						min = arr[i].length();
						index = i;
					}
				}
				
				for ( char c : arr[index].toCharArray() ) {
					set.add(c);
				}
				
				if (n == 1) {
					System.out.println(set.size());
				} else {
					int result = 0;
					boolean flag = false;
					for (char c : set ) {
						
						for ( int j = 0; j < arr.length; j++ ) {
							if ( j != index ) {
								if (arr[j].indexOf(c) != -1) {
									flag = true;
								} else {
									flag = false;
									break;
								}
							}
						}
						if(flag)
							result++;
					}
					
					System.out.println(result);	
				}
			}
		} catch ( Exception e ) {
			
		}
		
	}
}