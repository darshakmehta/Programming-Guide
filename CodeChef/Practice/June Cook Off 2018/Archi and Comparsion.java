import java.util.*;
import java.lang.*;
import java.io.*;
 
class Ideone
{

	public static find(int a, int b) {
		if(a > b) {
				System.out.println(1);
			} else if(a < b) {
				System.out.println(2);
			} else if(a == b) {
				System.out.println(0);
			}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		
		if(n % 2 != 0) {
			find(a,b);
		} else {
			a = Math.abs(a);
			b = Math.abs(b);
			find(a,b);
		}
	}
	
		
	}
} 