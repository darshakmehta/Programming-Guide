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
	
	public int heapMinimum(int a[]) {
		return a[1];
	}
	
	public int extractMin(int a[]) {
		if(heap_size < 1) {
			System.out.println("heap underflow");
			return -1;
		}
		int min = a[1];
		a[1] = a[heap_size];
		heap_size--;
		minHeapify(a,1);
		return min;
	}
	
	public void heapDecreaseKey(int a[], int i, int key) {
		if(key > a[i]) {
			System.out.println("new key is larger than current key");
			return;
		}
		a[i] = key;
		while(i>1 && a[parent(i)] > a[i]) {
			swap(a, i, parent(i));
			i = parent(i);
		}
	}
	
	public void heapEfficientDecreaseKey(int a[], int i, int key) {
		if(key > a[i]) {
			System.out.println("new key is larger than current key");
			return;
		}
		while(i>1 && a[parent(i)] > key) {
			//swap(a, i, parent(i)); 
			//change swaps to single assignment operation
			a[i] = a[parent(i)];
			i = parent(i);
		}
		a[i] = key;
	}
	
	public void minHeapInsert(int a[], int key) {
		heap_size++;
		a[heap_size] = Integer.MAX_VALUE;
		heapEfficientDecreaseKey(a, heap_size, key);
	}
	
	public void heapDelete(int a[], int i) {
		a[i] = a[heap_size];
		heap_size--;
		minHeapify(a,i);
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
		System.out.println();		
		
		int min = heap.heapMinimum(a);
		System.out.println("Minimum: " + min);
		
		int extractMinimum = heap.extractMin(a);
		System.out.println("extractMinimum: " + extractMinimum);
		
		heap.heapDecreaseKey(a,4,3);
		heap.heapEfficientDecreaseKey(a,10,4);
		heap.minHeapInsert(a,3);
		heap.minHeapInsert(a,15);
		System.out.println("Item deleted: " + a[12]);
		heap.heapDelete(a,12);
		
		System.out.println();	
		System.out.println("After");
		for(int i = 1; i<=heap.heap_size; i++)
			System.out.print(a[i] + " ");
		
		
	}
}