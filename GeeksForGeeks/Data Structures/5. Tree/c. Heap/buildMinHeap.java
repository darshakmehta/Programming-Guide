import java.util.*;
import java.lang.*;
import java.io.*;

class Heap {
	
	int heap_size;
	
	public int left(int i) {
		return (2*i); //left shift by 1 ==> i << 1
	}
	
	public int right(int i) {
		return (2*i + 1);
	}
	
	public int parent(int i) {
		return (int)Math.floor(i/2); //right shift by 1 ==> i >> 1
	}
	
	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void minHeapify(int a[], int i) {
		int l = left(i);
		int r = right(i);
		int smallest;
		if(l <= heap_size && a[l] < a[i])
			smallest = l;
		else
			smallest = i;
		if(r <= heap_size && a[r] < a[smallest])
			smallest = r;
		if(smallest != i) {
			swap(a, i, smallest);
			minHeapify(a, smallest);
		}
	}
	
	public void buildMinHeap(int a[], int n) {
		for(int i = (int)Math.floor(n/2); i >= 1; i--) {
			minHeapify(a,i);
		}
	}
	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //number of elements
		int a[] = new int[20];
		for(int i = 1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Before Min Build Heap");
		for(int i = 1; i<=n; i++)
			System.out.print(a[i] + " ");
		System.out.println();	
		
		Heap heap = new Heap();
		heap.heap_size = n;
		heap.buildMinHeap(a,n);
		
		System.out.println();	
		System.out.println("After Min Build Heap");
		for(int i = 1; i<=n; i++)
			System.out.print(a[i] + " ");
		
	}
}