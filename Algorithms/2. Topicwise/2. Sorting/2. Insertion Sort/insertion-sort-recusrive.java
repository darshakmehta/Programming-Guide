import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = sc.nextInt();
		Ideone ideone = new Ideone();
		ideone.insertionSortRecursive(a, a.length);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	public void insertionSortRecursive(int a[], int n) {
		if(n <= 1) return;

		insertionSortRecursive(a, n - 1);
		int last = a[n-1];
		int j = n - 2;
		
		while (j >= 0 && a[j] > last) {
			a[j + 1] = a[j];
			j--;
		}
		a[j + 1] = last;
	}
}