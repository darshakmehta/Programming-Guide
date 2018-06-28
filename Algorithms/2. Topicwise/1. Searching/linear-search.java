/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		Ideone ideone = new Ideone();
		int result = ideone.linearSearch(a, v);
		if(result == -1) {
			System.out.println("Value: " + v + " not found");
		}else {
			System.out.println("Value: "+ v + " found at index " + result);
		}
	}
	
	public int linearSearch(int a[], int value){
		for(int i = 0; i < a.length; i++){
			if(a[i] == value){
				return i;
			}
		}
		return -1;
	}
}