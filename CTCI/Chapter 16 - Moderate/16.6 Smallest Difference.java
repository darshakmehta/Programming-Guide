import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestDiff
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a[] = new int[4];
		int b[] = new int[6];

		for(int i = 0; i < 4; i++)
			a[i] = sc.nextInt();
		for(int i = 0; i < 6; i++)
			b[i] = sc.nextInt();

		Arrays.sort(a);
		Arrays.sort(b);
		int index1 = 0;
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		while(index1 < a.length && index2 < b.length) {
			int x = Math.abs(a[index1] - b[index2]);
			if(x < min) {
				min = x;
			}
			if(a[index1] < b[index2])
				index1++;
			else
				index2++;
		}

		System.out.println(min);

	}
}

/***

Consider two arrays A and B; sorting takes O(A log A + B log B) time and O(A + B) time to find the minium difference. Therefore overtime is O(A log A + B log B).
One optimization you can think is, if minimum is 0, we can return. Two things; first if we find min in early list its great, if it at the end, or not present we have overhead of checking one statement, therefore we can just leave it.

***/