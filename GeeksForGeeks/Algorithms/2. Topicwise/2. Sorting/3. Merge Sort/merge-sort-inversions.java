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
		for(int i = 0; i < size; i++)
			a[i] = sc.nextInt();
		Ideone ideone = new Ideone();
		int inversions = ideone.mergeSort(a, 0, a.length - 1);
		for(int i = 0 ;i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("Inverstions : "+ inversions);
	}
	
	public int mergeSort(int a[], int l, int r){
		if(l < r){
			int inversions = 0;		
			int mid = (l + r)/2;
			inversions += mergeSort(a, l, mid);
			inversions += mergeSort(a, mid + 1, r);
			inversions += merge(a,l,mid,r);	
			return inversions;
		}
		else
		return 0;
	}
	
	public int merge(int a[], int l, int mid, int r){
		int inversions = 0;
		int n1 = mid - l + 1;
		int n2 = r - mid;
		//System.out.println(n1 + " " + n2);
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i = 0; i< n1; i++)
			L[i] = a[l + i];
		for(int j = 0; j < n2; j++)
			R[j] = a[mid + 1 +j];
		int i = 0;
		int j = 0;
		int k = l;
		
		while(i<n1 && j<n2){
			if(L[i] <= R[j]){
				a[k] = L[i];
				i++;
			}
			else{
				a[k] = R[j];
				j++;
				inversions += n1 - i;
			}
			k++;
		}
		while(i<n1){
			a[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			a[k] = R[j];
			j++;
			k++;
		}
		return inversions;
	}
}