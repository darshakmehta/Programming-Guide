import java.util.*;
import java.lang.*;
import java.io.*;

class AllPairShortestPath
{
	public static int INF = 1000000;

	public void printDistanceMatrix(int[][] distance) {
		for(int i = 0; i < distance.length; i++) {
			for(int j = 0; j < distance.length; j++) {
				if(distance[i][j] == INF)
					System.out.print("INF" + " ");
				else
					System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printPathMatrix(int[][] path) {
		for(int i = 0; i < path.length; i++) {
			for(int j = 0; j < path.length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printPath(int[][] path, int source, int dest) {

		Deque<Integer> queue = new LinkedList<Integer>();
		queue.addFirst(dest);

		while(true) {
			dest = path[source][dest];
			if(dest == -1)
				return;
			queue.addFirst(dest);
			if(dest == source)
				break;

		}

		while(!queue.isEmpty()) {
			System.out.print(queue.pollFirst() + " ");
		}

	}
	
	public void shortestPath(int[][] graph, int[][] distance, int[][] path) {
		int len = graph.length;

		/* Copy graph to distance matrix */
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				distance[i][j] = graph[i][j];
				if(graph[i][j] != INF && i != j)
					path[i][j] = i;
				else
					path[i][j] = -1;
			}
		}

		/* Find shortest path and distance */
		/* Add all vertices one by one to the set of intermediate vertices */
		for(int k = 0; k < len; k++) {
			/* Pick all vertices as source one by one */
			for(int j = 0; j < len; j++) {
				/* Pick all vertices as destination for the above picked source */
				for(int i = 0; i < len; i++) {
					if(distance[i][k] == INF || distance[k][j] == INF) {
						continue;
					}
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}

		/* Check for negative weight cycle */
		for(int i = 0; i < distance.length; i++) {
			if(distance[i][i] < 0) {
				System.out.println("Negative Weight Cycle");
				return;
			}
		}
		System.out.println();
		printDistanceMatrix(distance);

		System.out.println();
		printPathMatrix(path);

		System.out.println();
		printPath(path, 0, 3);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		AllPairShortestPath shortPath = new AllPairShortestPath();	
		int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 
                        
        int[][] distance = new int[graph.length][graph.length];
        int[][] path = new int[graph.length][graph.length]; 
        shortPath.shortestPath(graph, distance, path);
	}
}

/**
*

Time Complexity: O(V^3)

The above program only prints the shortest distances. We can modify the solution to print the shortest paths also by storing the predecessor information in a separate 2D matrix.
Also, the value of INF can be taken as INT_MAX from limits.h to make sure that we handle maximum possible value. When we take INF as INT_MAX, we need to change the if condition in the above program to avoid arithmetic overflow.

*
**/