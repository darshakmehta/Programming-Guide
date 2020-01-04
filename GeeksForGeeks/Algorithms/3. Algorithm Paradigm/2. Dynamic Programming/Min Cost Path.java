import java.util.*;
import java.lang.*;
import java.io.*;

class MinCostPath //Tabulated Version O(mn)
{

	public static int minCost(int cost[][], int m, int n) {
		int pathCost[][] = new int[m+1][n+1];

		pathCost[0][0] = cost[0][0];
		for(int i = 1; i <= m; i++) {
			pathCost[i][0] = cost[i][0] + pathCost[i-1][0];
		}
		for(int j = 1; j <= n; j++) {
			pathCost[0][j] = cost[0][j] + pathCost[0][j - 1];
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				pathCost[i][j] = Math.min(pathCost[i - 1][j - 1], Math.min(pathCost[i][j - 1], pathCost[i - 1][j])) + cost[i][j];
			}
		}
		return pathCost[m][n];

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int cost[][] = {{1, 2, 3}, 
					  	{4, 8, 2}, 
					  	{1, 5, 3}};

		System.out.println(minCost(cost, 2,2));
	}
}


/***

Note: Naive version goes exponential time, as we explore same states again and again.

TODO: Try implementing Memoized version, since for large arrays consider, if all diagonal elements are smaller value, we might unnecessarily tabulate the cost for other rows and columns.

***/