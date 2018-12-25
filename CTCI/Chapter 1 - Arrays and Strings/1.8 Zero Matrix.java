import java.util.*;
import java.lang.*;
import java.io.*;

class ZeroMatrix //O(N) space for storing rows and columns with 0
{
	public void nullifyRow(int a[][], int row) {
		for(int j = 0; j < a[row].length; j++)
			a[row][j] = 0;
	}
	
	public void nullifyColumn(int a[][], int column) {
		for(int j = 0; j < a[0].length; j++)
			a[j][column] = 0;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		ZeroMatrix zeroMatrix =  new ZeroMatrix();
		Scanner sc = new Scanner(System.in);
		int n = 4;
		int a[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		//Before
		System.out.println("Before");
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}

		/* Extra space */
		// boolean rows[] = new boolean[n];
		// boolean columns[] = new boolean[n];
		// for(int i = 0; i < n; i++) {
		// 	for( int j = 0; j < n; j++) {
		// 		if(a[i][j] == 0) {
		// 			rows[i] = true;
		// 			columns[j] = true;
		// 		}
		// 	}
		// }
		
		// for(int i = 0; i < rows.length; i++) {
		// 	if(rows[i])
		// 		zeroMatrix.nullifyRow(a,i);
		// }
		// for(int i = 0; i < columns.length; i++) {
		// 	if(columns[i])
		// 		zeroMatrix.nullifyColumn(a,i);
		// }

		/* Without extra space */
		boolean firstRow = false;
		boolean firstCol = false;

		// Check First Row
		for(int i = 0; i < n; i++) {
			if(a[0][i] == 0)
				firstRow = true;
		}

		// Check First Column
		for(int i = 0; i < n; i++) {
			if(a[i][0] == 0)
				firstCol = true;
		}

		// Now use first row and first Column to store information from that particular row


		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(a[i][j] == 0) {
					a[i][0] = 0;
					a[0][j] = 0;
				}
			}
		}

		for(int i = 1; i < n; i++) {
			if(a[i][0] == 0) {
				zeroMatrix.nullifyRow(a, i);
			}
		}

		for(int i = 1; i < n; i++) {
			if(a[0][i] == 0) {
				zeroMatrix.nullifyColumn(a, i);
			}
		}


		if(firstRow) {
			zeroMatrix.nullifyRow(a, 0);
		}

		if(firstCol) {
			zeroMatrix.nullifyColumn(a, 0);
		}

		
		//After
		System.out.println("After");
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}

/*** 

Completed: O(1) space by remembering in first Row and first column of the matrix

TODO: Think if possible using Bit vector? What space will it take?

**/