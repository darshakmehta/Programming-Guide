import java.util.*;
import java.lang.*;
import java.io.*;

class ZeroMatrix //O(N) space for storing rows and columns with 0
{
	public void nullifyRow(int a[][], int row) {
		for(int j = 0; j < a[row].length; j++)
			a[row][j] = 0;
	}
	
	public void nullifyColum(int a[][], int column) {
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
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		boolean rows[] = new boolean[n];
		boolean columns[] = new boolean[n];
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < n; j++) {
				if(a[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for(int i = 0; i < rows.length; i++) {
			if(rows[i])
				zeroMatrix.nullifyRow(a,i);
		}
		for(int i = 0; i < columns.length; i++) {
			if(columns[i])
				zeroMatrix.nullifyColum(a,i);
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

/*** TODO: Solution using Bit vector, which can take up to O(1) space ***/