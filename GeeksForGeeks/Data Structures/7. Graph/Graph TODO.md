# DFS
1. [Find k-cores of an undirected graph](https://www.geeksforgeeks.org/find-k-cores-graph/)

To implement above algorithm, we do a modified DFS on the input graph and delete all the vertices having degree less than ‘K’, then update degrees of all the adjacent vertices, and if their degree falls below ‘K’ we will delete them too.

Time Complexity: O(V + E)
