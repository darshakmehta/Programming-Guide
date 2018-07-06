import java.util.*;
import java.lang.*;
import java.io.*;

class SwapWithoutTemp
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		//Solution 1 - Works with Intger
		a = a + b;
		b = a - b;
		a = a - b;
		

		//Solution 2: Bit Manipulation - Works for any datatype.

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a + " " + b);
	}
}