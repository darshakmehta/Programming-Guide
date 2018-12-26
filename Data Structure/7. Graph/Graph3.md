# [Count the number of nodes at given level in a tree using BFS.](https://ideone.com/KK7Bke)

Given a tree represented as undirected graph. Count the number of nodes at given level l. It may be assumed that vertex 0 is root of the tree.

BFS is a traversing algorithm which start traversing from a selected node (source or starting node) and traverse the graph layer wise thus exploring the neighbour nodes (nodes which are directly connected to source node). Then, move towards the next-level neighbour nodes.

As the name BFS suggests, traverse the graph breadth wise as follows:

1. First move horizontally and visit all the nodes of the current layer.
2. Move to the next layer.

In this code, while visiting each node, the level of that node is set with an increment in the level of its parent node i.e., level[child] = level[parent] + 1. This is how the level of each node is determined. The root node lies at level zero in the tree.

Explanation :

	     0         Level 0
	   /   \ 
	  1     2      Level 1
	/ |\    |
	3 4 5   6      Level 2

Given a tree with 7 nodes and 6 edges in which node 0 lies at 0 level. Level of 1 can be updated as : level[1] = level[0] +1 as 0 is the parent node of 1. Similarly, the level of other nodes can be updated by adding 1 to the level of their parent.
level[2] = level[0] + 1, i.e level[2] = 0 + 1 = 1.
level[3] = level[1] + 1, i.e level[3] = 1 + 1 = 2.
level[4] = level[1] + 1, i.e level[4] = 1 + 1 = 2.
level[5] = level[1] + 1, i.e level[5] = 1 + 1 = 2.
level[6] = level[2] + 1, i.e level[6] = 1 + 1 = 2.

Then, count of number of nodes which are at level l(i.e, l=2) is 4 (node:- 3, 4, 5, 6)

# Count all possible paths between two vertices

