import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[] = new int[]{1,2,3,4,5};
		
		/* Cyclic Rotate by one */
		
		int temp = a[a.length - 1];
		for(int i = a.length - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = temp;
		for(int i : a) {
			System.out.print(i +" ");
		}
	}
}

/***

Following are steps.
1) Store last element in a variable say x.
2) Shift all elements one position ahead.
3) Replace first element of array with x.

***/