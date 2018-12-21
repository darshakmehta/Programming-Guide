import java.util.*;
import java.lang.*;
import java.io.*;

class Graph
{

	int V;
	LinkedList<Integer> adjListArray[];

	Graph(int V) {
		this.V = V;
		adjListArray = new LinkedList[V]; //generic array creation
		for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList();
        }
	}

	public void addEdge(int u, int v) {
		this.adjListArray[u].addFirst(v);
		this.adjListArray[v].addFirst(u);
	}

	public void printGraph() {
		for(int v = 0; v < V; v++) {
			System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer in: adjListArray[v]){
                System.out.print(" -> "+in);
            }
            System.out.println("\n");
		}
	}

	public void BFS(int s) {
		//Mark all vertices as not visited
		boolean visited[] = new boolean[V];

		//Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while(queue.size() > 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adjListArray[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if( !visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
        graph.BFS(1);
	}
}