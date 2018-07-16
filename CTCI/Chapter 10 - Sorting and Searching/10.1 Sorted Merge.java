import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a[] = {2, 4, 6, 8, 10};
		int b[] = {1, 3, 5, 7, 9};
		int n = a.length;
		int m = b.length;
		int i = 0, j = 0, k = 0;

		//Solution 1: Using temp array, Running time O(n + m); Space: O(n+m)
		int temp[] = new int[n + m];
		while(i < n && j < m) {
			if(a[i] < b[j]) 
				temp[k++] = a[i++];
			else
				temp[k++] = b[j++];
		}
		
		while(i < n) 
			temp[k++] = a[i++];
		while(j < m) 
			temp[k++] = a[j++];
		
		System.out.println("With temp array: ");
		i = 0;
		while(i < temp.length) {
			System.out.print(temp[i++] + " ");
		}
		

		//Solution 2: Without extra space
		
		int[] firstArr = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] secondArr = {1, 4, 7, 6, 7, 7};
	
		int firstArrIndex = 8 - 1; //8th is the last element in first array
		int secondArrIndex = secondArr.length - 1;
		int mergeIndex = 8 + secondArr.length - 1;

		while(secondArrIndex >= 0) {
			if(firstArrIndex >= 0 && firstArr[firstArrIndex] > secondArr[secondArrIndex]) {
				firstArr[mergeIndex] = firstArr[firstArrIndex--];
			} 
			else {
				firstArr[mergeIndex] = secondArr[secondArrIndex--];
			}
			mergeIndex--;
		}
		System.out.println();
		System.out.println("Without temp array: ");
		i = 0;
		while(i < firstArr.length) {
			System.out.print(firstArr[i++] + " ");
		}

		
	}
}
