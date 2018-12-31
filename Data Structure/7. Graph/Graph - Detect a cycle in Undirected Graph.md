# Detect cycle in an undirected graph

[Given an undirected graph](https://www.geeksforgeeks.org/wp-content/uploads/cycleGraph.png), how to check if there is a cycle in the graph? For example, the following graph has a cycle 1-0-2-1.

## Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).

TODO: [union-find algorithm for cycle detection in undirected graphs.](https://www.geeksforgeeks.org/union-find/)
The time complexity of the union-find algorithm is O(ELogV). 

Like directed graphs, we can use DFS to detect cycle in an undirected graph in O(V+E) time. We do a DFS traversal of the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex, we say that there is no cycle. The assumption of this approach is that there are no parallel edges between any two vertices.

## Time Complexity: The program does a simple DFS Traversal of graph and graph is represented using adjacency list. So the time complexity is O(V+E)

TODO: Can we use BFS to detect cycle in an undirected graph in O(V+E) time? What about directed graphs?