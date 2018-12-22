/* Solution 1: Using Floyd Warshall => O(V^3) */

import java.util.*;
import java.lang.*;
import java.io.*;

class AllPairShortestPath
{
	public static int INF = 1000000;

	public void printReachMatrix(int[][] reach) {
		for(int i = 0; i < reach.length; i++) {
			for(int j = 0; j < reach.length; j++) {
				if(reach[i][j] == INF)
					System.out.print("INF" + " ");
				else
					System.out.print(reach[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void reachAbility(int[][] graph, int[][] reach) {
		int len = graph.length;

		/* Copy graph to reach matrix */
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				reach[i][j] = graph[i][j];
			}
		}

		/* Find shortest path and reach */
		/* Add all vertices one by one to the set of intermediate vertices */
		for(int k = 0; k < len; k++) {
			/* Pick all vertices as source one by one */
			for(int j = 0; j < len; j++) {
				/* Pick all vertices as destination for the above picked source */
				for(int i = 0; i < len; i++) {
					reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
				}
			}
		}
		System.out.println();
		printReachMatrix(reach);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		AllPairShortestPath shortPath = new AllPairShortestPath();	
		int graph[][] = new int[][]{ {1, 1, 0, 1}, 
                                      {0, 1, 1, 0}, 
                                      {0, 0, 1, 1}, 
                                      {0, 0, 0, 1} 
                                    }; 
                        
        int[][] reach = new int[graph.length][graph.length];
        
        shortPath.reachAbility(graph, reach);
	}
}

/* Solution 2: Using DFS => O(V^2) */

