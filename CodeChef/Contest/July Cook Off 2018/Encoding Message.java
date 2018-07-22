import java.util.*;
import java.lang.*;
import java.io.*;
 
class Solution
{
 
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = a[i];
	}
 
	
 
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		char c[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		while(t-- > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			StringBuffer sb = new StringBuffer(s);
			int x = n;
			if(n % 2 != 0) {
				x = n - 1;		
			}
			
			for(int i = 0; i < x - 1; i+=2) {
				char temp = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(i + 1));
				sb.setCharAt(i + 1, temp);
			}
			
			for(int i = 0; i < n; i++) {
				char temp = sb.charAt(i);
				sb.setCharAt(i, c['z' - temp]);
			}
			
		System.out.println(sb.toString());	
			
		}
	}
} 