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
	
	public void dfs(int vertex) {
		boolean[] visited = new boolean[V];
		dfsUtil(vertex, visited);
	}

	public void dfsMotherVertexEfficient() {
		boolean[] visited = new boolean[V];
		int lastVisited = 0;

		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				dfsUtil(i, visited);
				lastVisited = i;
			}
		}
		System.out.println();

		visited = new boolean[V];
		dfsUtil(lastVisited, visited);
		boolean flag = false;

		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				flag = true;
				break;
			}
		}

		System.out.println();

		if(flag) {
			System.out.println(lastVisited + " Is Not a mother vertex");
		} else {
			System.out.println(lastVisited + " Is A mother vertex");
		}
	}
	
	//Naive Approach O(V(E + V))
	public void dfsMotherVertex(int vertex) {

		boolean[] visited = new boolean[V];
		dfsUtil(vertex, visited);

		/* Check for all vertex by passing new visited array if it explores all the nodes it is a mother vertex */

		/* Checking the visited array if all were explored */
		boolean flag = false;
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				flag = true;
				break;
			}
		}

		System.out.println();

		if(flag) {
			System.out.println(vertex + " Is Not a mother vertex");
		} else {
			System.out.println(vertex + " Is A mother vertex");
		}
	}
	
	public void dfsUtil(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");

		List<Integer> innerList = list.get(vertex);
		for(int i = 0; i < innerList.size(); i++) {
			Integer in = innerList.get(i);
			if(!visited[in]) {
				dfsUtil(in, visited);
			}
		}
	}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int directedV = 3;
		Graph directedGraph = new Graph(directedV);
		
		directedGraph.addDirectedEdge(0, 1);
		directedGraph.addDirectedEdge(1, 2);
		directedGraph.addDirectedEdge(2, 0); 

		System.out.println("Directed Graph");
		directedGraph.printGraph();
		
		// System.out.println();
		// System.out.println("DFS of given Directed Graph:");
		// directedGraph.dfs(2);
		
		System.out.println();
		System.out.println("Is 2 a Mother Vertex?" );
		directedGraph.dfsMotherVertex(2);

		System.out.println();
		System.out.println("Is 2 a Mother Vertex following Kosaraju's SCC?" );
		directedGraph.dfsMotherVertexEfficient();
		
	}
}

/**

Note:
Case 1:- Undirected Connected Graph : In this case, all the vertices are mother vertices as we can reach to all the other nodes in the graph.
Case 2:- Undirected/Directed Disconnected Graph : In this case, there is no mother vertices as we cannot reach to all the other nodes in the graph.
Case 3:- Directed Connected Graph : In this case, we have to find a vertex -v in the graph such that we can reach to all the other nodes in the graph through a directed path.

# A Naive approach : 

A trivial approach will be to perform a DFS/BFS on all the vertices and find whether we can reach all the vertices from that vertex. This approach takes O(V(E+V)) time, which is very inefficient for large graphs.

# Can we do better?

We can find a mother vertex in O(V+E) time. The idea is based on Kosaraju’s Strongly Connected Component Algorithm. In a graph of strongly connected components, mother vertices are always vertices of source component in component graph. The idea is based on below fact.

If there exist mother vertex (or vertices), then one of the mother vertices is the last finished vertex in DFS. (Or a mother vertex has the maximum finish time in DFS traversal).

A vertex is said to be finished in DFS if a recursive call for its DFS is over, i.e., all descendants of the vertex have been visited.

How does the above idea work?
Let the last finished vertex be v. Basically, we need to prove that there cannot be an edge from another vertex u to v if u is not another mother vertex (Or there cannot exist a non-mother vertex u such that u-→v is an edge). There can be two possibilities.

1. Recursive DFS call is made for u before v. If an edge u-→v exists, then v must have finished before u because v is reachable through u and a vertex finishes after all its descendants.
2. Recursive DFS call is made for v before u. In this case also, if an edge u-→v exists, then either v must finish before u (which contradicts our assumption that v is finished at the end) OR u should be reachable from v (which means u is another mother vertex).

# Algorithm :

1. Do DFS traversal of the given graph. While doing traversal keep track of last finished vertex ‘v’. This step takes O(V+E) time.
2. If there exist mother vertex (or vetices), then v must be one (or one of them). Check if v is a mother vertex by doing DFS/BFS from v. This step also takes O(V+E) time.

Time Complexity : O(V + E)

**/