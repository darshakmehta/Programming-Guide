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
	}
	
	public int binarySearch(int a[], int value){
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
}