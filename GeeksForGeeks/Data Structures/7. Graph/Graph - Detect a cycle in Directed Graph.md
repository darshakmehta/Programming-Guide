# Detect Cycle in a Directed Graph

Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false. For example, the following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your function must return true.

Depth First Traversal can be used to detect a cycle in a Graph. `DFS for a connected graph produces a tree.` There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS. In the following graph, there are 3 back edges, marked with a cross sign. We can observe that these 3 back edges indicate 3 cycles present in the graph.

[Image](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/cycle.png)

`For a disconnected graph, we get the DFS forest as output.` To detect cycle, we can check for a cycle in individual trees by checking back edges.

To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. The edge that connects current vertex to the vertex in the recursion stack is a back edge. We have used recStack[] array to keep track of vertices in the recursion stack.

## Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).

# Detect Cycle in a directed graph using colors

Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false. For example, the following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your function must return true.

### [Solution](https://cdncontribute.geeksforgeeks.org/wp-content/uploads/detect-cycle.png)

Depth First Traversal can be used to detect cycle in a Graph. DFS for a connected graph produces a tree. There is a cycle in a graph only if there is a back edge present in the graph. `A back edge is an edge that is from a node to itself (selfloop) or one of its ancestor in the tree produced by DFS.`

In the following graph, there are 3 back edges, marked with cross sign. We can observe that these 3 back edges indicate 3 cycles present in the graph.

For a disconnected graph, we get the DFS forest as output. To detect cycle, we can check for cycle in individual trees by checking back edges.

The solution is from CLRS book. The idea is to do DFS of given graph and while doing traversal, assign one of the below three colors to every vertex.

	WHITE : Vertex is not processed yet.  Initially
	        all vertices are WHITE.

	GRAY : Vertex is being processed (DFS for this 
	       vertex has started, but not finished which means
	       that all descendants (in DFS tree) of this vertex
	       are not processed yet (or this vertex is in function
	       call stack)

	BLACK : Vertex and all its descendants are 
	        processed.

	While doing DFS, if we encounter an edge from current 
	vertex to a GRAY vertex, then this edge is back edge 
	and hence there is a cycle.

