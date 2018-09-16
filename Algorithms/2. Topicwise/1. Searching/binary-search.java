import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
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
		Solution solution = new Solution();
		int result = solution.binarySearch(a, v);
		if(result == -1) {
			System.out.println("Value: " + v + " not found");
		}else {
			System.out.println("Value: "+ v + " found at index " + result);
		}

		int recursiveResult = solution.recursiveBinarySearch(a, 0, size - 1, v);
		if(recursiveResult == -1) {
			System.out.println("Value: " + v + " not found");
		}else {
			System.out.println("Value: "+ v + " found at index " + recursiveResult);
		}
	}
	
	public int binarySearch(int a[], int value){  //iterative
		int low = 0;
		int high = a.length - 1;
		int mid;
		while(low <=high){
			mid =  (low + high) / 2;
			if(a[mid] == value)
				return mid;
			else if(a[mid] < value){
				low = mid + 1;
			}
			else if(a[mid] > value){
				high = mid - 1;
			}
		}
		return -1;
	}

	public int recursiveBinarySearch(int a[], int low, int high, int value){  //recursive
		int mid;
		while(low <= high){
			mid =  (low + high) / 2;
			if(a[mid] == value)
				return mid;
			else if(a[mid] < value){
				return recursiveBinarySearch(a, mid + 1, high, value); 
			}
			else if(a[mid] > value){
				return recursiveBinarySearch(a, low, mid - 1, value);
			}
		}
		return -1;
	}

}

/***

Algorithmic Paradigm: Decrease and Conquer

Iterative Solution:

Time complexity: O(log n)
Space complexity: O(1)

Recursive Solution

Time complexity: O(log n)
Space complexity: O(log n) recursion call stack space


Note: Binary search requires the array to be sorted

***/