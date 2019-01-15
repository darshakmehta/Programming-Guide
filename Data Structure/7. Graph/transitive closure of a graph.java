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
	
	public static void main (String[] args) throws java.lang.Exception {
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

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
	int V;
	List<List<Integer>> list;

	Graph(int V) {
		this.V = V;
		list = new ArrayList<List<Integer>>();
		for(int i = 0; i < V; i++) {
			List<Integer> vertex = new ArrayList<Integer>();
			list.add(vertex);
		}
	}
	
	public void addDirectedEdge(int u, int v) {
		this.list.get(u).add(v);
	}
	
	public void addUndirectedEdge(int u, int v) {
		this.list.get(u).add(v);
		this.list.get(v).add(u); //symmetric
	}

	public void printGraph() {
		for(int i = 0; i < V; i++) {
			List<Integer> vertices = list.get(i);
			System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
			for(Integer vertice : vertices) {
				System.out.print(" -> " + vertice);
			}
			System.out.println();
		}
	}
	
	public void transitiveClosure(boolean[][] visited) {
		for(int i = 0; i < V; i++) {
			dfsUtil(i, i, visited);
		}
	}
	
	public void dfsUtil(int s, int v, boolean[][] visited) {
		
		visited[s][v] = true;

		List<Integer> innerList = list.get(v);

		for (Integer vertex : innerList) {
			if (!visited[s][vertex]) {
				dfsUtil(s, vertex, visited);
			}
		}
	}

	public void printTransitiveClosure(boolean[][] visited) {
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println(Arrays.deepToString(twoDm).replace("], ", "]\n"));
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int directedV = 4;
		Graph directedGraph = new Graph(directedV);
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(0, 2);
		directedGraph.addDirectedEdge(2, 0);
		directedGraph.addDirectedEdge(1, 2);
		directedGraph.addDirectedEdge(2, 3);

		System.out.println("Directed Graph");
		directedGraph.printGraph();
		
		System.out.println();
		boolean[][] visited = new boolean[directedV][directedV];
		directedGraph.transitiveClosure(visited);
		System.out.println();
		directedGraph.printTransitiveClosure(visited);
	}
}