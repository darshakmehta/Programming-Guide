import java.util.*;
import java.lang.*;
import java.io.*;

class RotateMatrix //O(n^2)
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 4;
		int a[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		//Before
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				// Save top
				int top = a[first][i];
				
				//Left --> Top
				a[first][i] = a[last - offset][first];
				
				//Bottom --> Left
				a[last - offset][first] = a[last][last - offset];
				
				//Right --> Bottom
				a[last][last - offset] = a[i][last];
				
				//Top --> Right
				a[i][last] = top;
			}
		}
		
		//After
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}