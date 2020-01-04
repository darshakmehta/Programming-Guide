import java.util.*;
import java.lang.*;
import java.io.*;

class Heap {

	int heap_size;
	
	public int left(int i) {
		return (2*i);
	}
	
	public int right(int i) {
		return (2*i + 1);
	}
	
	public int parent(int i) {
		return (int)Math.floor(i/2);
	}
	
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void maxHeapify(int a[], int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if(l <= heap_size && a[l] > a[i])
			largest = l;
		else
			largest = i;
		if(r <= heap_size && a[r] > a[largest])
			largest = r;
		if(largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest);
		}
	}
	
	public void buildMaxHeap(int a[], int n) {
		for(int i = (int)Math.floor(n/2); i >= 1; i--) {
			maxHeapify(a,i);
		}
	}
	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //number of elements
		int a[] = new int[20];
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Before Max Build Heap");
		for(int i = 1; i <= n; i++)
			System.out.print(a[i] + " ");
		System.out.println();	
		
		Heap heap = new Heap();
		heap.heap_size = n;
		heap.buildMaxHeap(a,n);
		
		System.out.println();	
		System.out.println("After Max Build Heap");
		for(int i = 1; i <= n; i++)
			System.out.print(a[i] + " ");
	}
}