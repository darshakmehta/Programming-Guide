import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
	
		System.out.println(selectionSort(s.toCharArray()));
	}
	
	public static String selectionSort(char[] c) { //simple but inefficient 
		int min;
		char temp;
		for (int i = 0; i < c.length - 1; i++) {
			min = i; //minIndex	
			for (int j = i + 1; j < c.length; j++) {
				if(c[j] < c[min])
					min = j;
			}
			// Swap
			temp = c[i];
			c[i] = c[min];
			c[min] = temp;
		}
		return new String(c);
	}
}